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


public class GSM_Obs extends Observation {
    String mcc;
    String mnc;
    String lac;
    String cid;

    public String id() {
        return mcc+","+mnc+","+lac+","+cid;
    }
}



