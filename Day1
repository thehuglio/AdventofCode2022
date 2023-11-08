package org.thehuglio;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        File file = new File("data.txt");
        Reader reader =  new Reader(file);
        System.out.println(reader.data);
        int calories = 0;
        List<Integer> top3 = new LinkedList<Integer>();
        top3.add(0);
        top3.add(0);
        top3.add(0);
        for (String value : reader.data) {
            if (!Objects.equals(value, "")) {
                calories += Integer.parseInt(value);
            } else {
                for (int i = 0; i < 3; i++) {
                    if (top3.get(i) < calories) {
                        top3.add(i, calories);
                        break;
                    }
                }
                calories = 0;
            }
        }

        System.out.println(top3.get(0) + top3.get(1) + top3.get(2));
    }
}
