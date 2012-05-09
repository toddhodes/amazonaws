package org.toddh.hadoop;

import java.io.IOException;
import java.io.File;
import java.util.*;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;




/**
 * create average cell locations via:
 * - remove cells with too few observations
 * - remove outliers
 * - remove cells with too little uncertainty
 */
public class CellDB {
 	
    public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text> {
        public void map(LongWritable key, 
                        Text value, 
                        OutputCollector<Text, Text> output, 
                        Reporter reporter) throws IOException {

            String line = value.toString();
            Observation obs = Observation.makeObs(line);
            if (obs == null) return;

            Text id = new Text(obs.id());
            Text val = new Text(line);
            output.collect(id, val);
        }
    }


    public static class Reduce extends MapReduceBase implements Reducer<Text, Text, Text, Text> {
        public void reduce(Text key, 
                           Iterator<Text> values, 
                           OutputCollector<Text, Text> output, 
                           Reporter reporter) throws IOException {

            // need something like this if running a Combiner
            //if (key.toString().indexOf("CELL:") != -1) return;


            List<Text> saved_values = new ArrayList<Text>();

            float lat_sum = 0.0f;
            float lon_sum = 0.0f;
            int count = 0;

            while (values.hasNext()) {
                Text val = values.next();
                saved_values.add(val);

                String line = val.toString();
                Observation obs = Observation.makeObs(line);
                if (obs == null) {
                    reporter.setStatus("bad input line: " + line);
                    continue;
                }

                /// debug: log our intermediate values
                //output.collect(key, new FloatWritable(val));            

                lon_sum += obs.lon;
                lat_sum += obs.lat;
                count++;
            }

            float lon_avg = lon_sum / count;
            float lat_avg = lat_sum / count;
            Coord avg = new Coord(lon_avg, lat_avg);

            /// debug: log totals
            //output.collect(new Text(key.toString()+ "-count"), new FloatWritable(count * 1.0f));
            
            // ### remove cells with too few observations ###
            int min_observations = 4;
            if (count < min_observations) {
                output.collect(key, new Text("too few obs (0 / " + count + ")"));
                return;
            }


            List<Text> outliers = new ArrayList<Text>();
            for (Text val : saved_values) {
                String line = val.toString();
                Observation obs = Observation.makeObs(line);
                if (obs == null) continue;
                double dist = avg.distance_to(obs);

                // ### remove outliers
                int max_distance = 1000;
                if (dist > max_distance) {
                    outliers.add(val);
                }

                // ### remove cells with too little uncertainty ###
                int min_uncertainty = 150;
                if (obs.uncertainty != null && dist + obs.uncertainty >= min_uncertainty) {
                    if (!outliers.contains(val))
                        outliers.add(val);
                }

            }


            // process removals
            for (Text val : outliers) {
                saved_values.remove(val);
            }

            // recalulate actual results
            lat_sum = 0.0f;
            lon_sum = 0.0f;
            count = 0;
            for (Text val : saved_values) {
                String line = val.toString();
                Observation obs = Observation.makeObs(line);
                if (obs == null) continue;
                lon_sum += obs.lon;
                lat_sum += obs.lat;
                count++;
            }


            // output the results            
            //output.collect(key, new Text("CELL:" + avg.lon +", "+ avg.lat 
            //                             + " (" + (count + outliers.size()) + ")"));
            output.collect(key, new Text(lon_sum/count +", "+ lat_sum/count
                                         + " (" + count + " / " + (count + outliers.size()) + ")"));

        }
    }


    public static void main(String[] args) throws Exception {
        JobConf conf = new JobConf(CellDB.class);
        conf.setJobName("CellDB");
 	
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(Text.class);
 	
        conf.setMapperClass(Map.class);
        //conf.setCombinerClass(Reduce.class);
        conf.setReducerClass(Reduce.class);
 	
        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);
 	
        FileInputFormat.setInputPaths(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));
 	
        JobClient.runJob(conf);
    }


}
 	


