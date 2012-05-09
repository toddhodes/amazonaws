package org.myorg;

import java.io.IOException;
import java.util.*;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;

// 1       7733277595340313073     37.84030638     -122.29092643   80      2009-11-10 17:59:46       2009-11-10 17:59:48     00:1C:57:E1:17:F0       wavewireless    -67


public class Centroid {
 	
    public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, FloatWritable> {
        private Text word = new Text();
 	
        public void map(LongWritable key, Text value, OutputCollector<Text, FloatWritable> output, Reporter reporter) throws IOException {
            String line = value.toString();
            StringTokenizer tokenizer = new StringTokenizer(line);
            
            FloatWritable lon = new FloatWritable(0.0f);
            FloatWritable lat = new FloatWritable(0.0f);
            Text MAC = new Text();

            int count = 0;
            while (tokenizer.hasMoreTokens()) {
                String tok = tokenizer.nextToken();

                if ("id".equals(tok))
                    break;

                if (count == 2) {
                    lon = new FloatWritable(Float.parseFloat(tok));
                } else if (count == 3) {
                    lat = new FloatWritable(Float.parseFloat(tok));
                } else if (count == 9) {
                    MAC.set(tok + "-lon");
                    output.collect(MAC, lon);
                    MAC.set(tok + "-lat");
                    output.collect(MAC, lat);
                } 
                count++;
            }
        }
    }
 	
    public static class Reduce extends MapReduceBase implements Reducer<Text, FloatWritable, Text, FloatWritable> {
        public void reduce(Text key, Iterator<FloatWritable> values, OutputCollector<Text, FloatWritable> output, Reporter reporter) throws IOException {
            float sum = 0.0f;
            int count = 0;
            while (values.hasNext()) {
                sum += values.next().get();
                count++;
            }
            output.collect(key, new FloatWritable(sum/count));
        }
    }
 	
    public static void main(String[] args) throws Exception {
        JobConf conf = new JobConf(Centroid.class);
        conf.setJobName("centroid");
 	
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(FloatWritable.class);
 	
        conf.setMapperClass(Map.class);
        conf.setCombinerClass(Reduce.class);
        conf.setReducerClass(Reduce.class);
 	
        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);
 	
        FileInputFormat.setInputPaths(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));
 	
        JobClient.runJob(conf);
    }
}
 	


