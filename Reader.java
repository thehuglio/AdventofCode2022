package org.thehuglio;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Reader {
    // stores all the data out of a text file (every line is added in the list, every empty line will be an empty string -> "")
    List<String> data = new LinkedList<>();
    // the file name/location
    File file;
    // starts the datareader and assigns the file
    public Reader(File file) {
        this.file = file;
        datareader();
    }
    // reads the data out of the file
    private void datareader() {
        try {
            LineNumberReader reader = new LineNumberReader(new FileReader(file));
            for(int i = 0;i <= (reader.getLineNumber());i++)
            {
                data.add(reader.readLine().replace(" ",""));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // removes the last index (the last index will be a null so won't have anything to do with the file
            data.remove(data.size()-1);
        }

    }
}

