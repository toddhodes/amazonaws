package org.toddh.hadoop;

import java.io.IOException;
import java.util.*;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;


public class Coord {
    Float lon;
    Float lat;

    public Coord() { }

    public Coord(Float lon, Float lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public Coord(float lon, float lat) {
        this.lon = new Float(lon);
        this.lat = new Float(lat);
    }

    public double distance_to(Coord other) {
        float y = other.lat - lat;
        float x = other.lon - lon;
        int r = 6371000;
        double cx = Math.cos(Math.toRadians((lat + other.lat) / 2.0)) * x;

        return Math.PI / 180.0 * r * Math.sqrt(cx * cx + y * y);
    }

}

