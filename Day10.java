//part 1
public class Main {

    private static final Reader reader = new Reader(new File("data.txt"));
    private static int x = 1,totalcycle = 0,total = 0;
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        System.out.println(reader.data);
        List<Integer> onrunningcycles = new LinkedList<>();
        for (int i = 0; i < (reader.data.size()*2); i += 40) {
            onrunningcycles.add(i);
        }
        for (String s : reader.data) {
            totalcycle++;
            if () {
                addition();
            }
            if (!s.equals("noop")) {
                int add = Integer.parseInt(s.split(" ")[1]);
                totalcycle++;
                if (onrunningcycles.contains(totalcycle)) {
                    addition();
                }
                x += add;
            }
        }
        System.out.println(total);
    }
    private static void addition() {
        total += x * totalcycle
    }
}
//part 2
package org.thehuglio;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Reader reader = new Reader(new File("data.txt"));
    private static int x = 1,totalcycle = 0;
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        System.out.println(reader.data);
        for (String s : reader.data) {
            addition(x == totalcycle || x == totalcycle-1 || x == totalcycle+1);
            totalcycle++;
            if (!s.equals("noop")) {
                int add = Integer.parseInt(s.split(" ")[1]);
                addition(x == totalcycle || x == totalcycle-1 || x == totalcycle+1);
                totalcycle++;
                x += add;
            }
        }
        System.out.println(stringBuilder);
    }
    private static void addition(Boolean b) {
        if (totalcycle == 40) {
            System.out.println(stringBuilder);
            stringBuilder = new StringBuilder();
            totalcycle = 0;
            addition(x == totalcycle || x == totalcycle-1 || x == totalcycle+1);
            return;
        }
        if (b) {
            stringBuilder.append("#");
        } else {
            stringBuilder.append("-");
        }
    }
}
