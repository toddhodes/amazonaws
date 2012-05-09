package org.toddh.hadoop;

import java.io.IOException;
import java.util.*;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;



// OpenCellId
// 542009,42.3652839660645,-71.1137771606445,310,26,5194,60293,15315,2,\N,2008-04-05 20:02:35,2006-01-18 23:25:31,7
// XXX



public class OpenCellIdObs extends Observation {
    String mcc;
    String mnc;
    String lac;
    String cid;
    // XXX

    public String id() {
        return mcc+","+mnc+","+lac+","+cid;
    }
}



