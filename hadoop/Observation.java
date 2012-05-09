package org.toddh.hadoop;

import java.io.IOException;
import java.util.*;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;


// GSM: (5,6) of 8
// 310     410     56994   787655  -122.291068333333       37.840315       132     1249528508

// CDMA: (4,5) of 7
// 4       264     4183    -122.29113      37.84064        67.88   1249533613

// OpenCellId
// 542009,42.3652839660645,-71.1137771606445,310,26,5194,60293,15315,2,\N,2008-04-05 20:02:35,2006-01-18 23:25:31,7,???
// id,lat,lon,mcc,mnc,lac,cellid,id_of_Cell,userid,extraInfo,created_at,measured_at,signal


public class Observation extends Coord {

    String timestamp;
    Float uncertainty;

    public String id() {
        return "noID";
    }
    

    public static Observation makeObs(String input) {
        Observation obs = null;
        String[] s = input.split("\t");
        if (s.length == 7) {
            CDMA_Obs o = new CDMA_Obs();
            o.bid = s[0];
            o.nid = s[1];
            o.sid = s[2];
            o.lon = Float.parseFloat(s[3]);
            o.lat = Float.parseFloat(s[4]);
            o.uncertainty = Float.parseFloat(s[5]);
            o.timestamp = s[6];
            obs = o;
        } else if (s.length == 8) {
            GSM_Obs o = new GSM_Obs();
            o.mcc = s[0];
            o.mnc = s[1];
            o.lac = s[2];
            o.cid = s[3];
            o.lon = Float.parseFloat(s[4]);
            o.lat = Float.parseFloat(s[5]);
            o.uncertainty = Float.parseFloat(s[6]);
            o.timestamp = s[7];
            obs = o;
            
        } else {
            s = input.split(",");
            if (s.length == 12 || s.length == 13) {
                OpenCellIdObs o = new OpenCellIdObs();
                // 0 = item id?
                if ("\\N".equals(s[1]) || "\\N".equals(s[2])) {
                    //throw new NumberFormatException("bad input line: " + input);
                    return null;
                }
                o.lat = Float.parseFloat(s[1]);
                o.lon = Float.parseFloat(s[2]);
                o.mcc = s[3];
                o.mnc = s[4];
                o.lac = s[5];
                o.cid = s[6];
                // 7-9 ?
                o.timestamp = s[10];
                // 11?

                // ???
                //o.uncertainty = Float.parseFloat(s[?]);

                if (s.length == 13) {
                    // 12?
                }

                obs = o;

            }
        }

        if (obs == null) {
            System.out.println("ERROR: bad data (" + s.length +"): '" + input + "'");
        }
        
        return obs;
    }
    
}
 	


