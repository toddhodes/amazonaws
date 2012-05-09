package org.toddh.hadoop;

import java.io.IOException;
import java.util.*;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;

// CDMA: (4,5) of 7
// 4       264     4183    -122.29113      37.84064        67.88   1249533613

public class CDMA_Obs extends Observation {
    String bid;
    String nid;
    String sid;

    public String id() {
        return bid+","+nid+","+sid;
    }
}

    



