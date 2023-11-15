//make sure the data has no spaces in front of the text
package org.thehuglio;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Reader reader = new Reader(new File("data.txt"));
    static Monkeys[] monkeys;
    static int limitprotectionnumber = 1;

    public static void main(String[] args) {
        System.out.println(reader.data);
        monkeys = new Monkeys[8];
        for (int i = 0; i < reader.data.size(); i += 7) {
            List<Long> items = new LinkedList<>();
            String[] split = reader.data.get(i + 1).split(" ");
            for (int j = 2; j < split.length; j++) {
                items.add(Long.parseLong(split[j].split(",")[0]));
            }
            split = reader.data.get(i + 2).split(" ");

            monkeys[i/7] = (new Monkeys(
                    items,
                    split[4],
                    getdataint(i + 2,5),
                    getdataint(i+4,5),
                    getdataint(i+5,5),
                    getdataint(i+3,3),
                    i/7));
            limitprotectionnumber *= getdataint(i+3,3);
        }
        for (int i = 0; i < 10000;i++) {
            for (Monkeys monkeys1 : monkeys) {
                monkeys1.play();
            }
        }
        long mon1 = 0;
        long mon2 = 0;
        for (Monkeys monkeys1 : monkeys) {
            if (monkeys1.getTotalinspections() > mon1) {
                mon2 = mon1;
                mon1 = monkeys1.getTotalinspections();
                continue;
            }
            if (monkeys1.getTotalinspections() > mon2) {
                mon2 = monkeys1.getTotalinspections();
            }
        }
        System.out.println(mon1 + " " + mon2);
        System.out.println(mon1 * mon2);
    }
    private static int getdataint(int sindex,int lindex) {
        String s = reader.data.get(sindex).split(" ")[lindex];
        if (s.equals("old")) {
            return 0;
        }
        return Integer.parseInt(s);
    }
}

package org.thehuglio;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Reader reader = new Reader(new File("data.txt"));
    static Monkeys[] monkeys;
    static int limitprotectionnumber = 1;

    public static void main(String[] args) {
        System.out.println(reader.data);
        monkeys = new Monkeys[8];
        for (int i = 0; i < reader.data.size(); i += 7) {
            List<Long> items = new LinkedList<>();
            String[] split = reader.data.get(i + 1).split(" ");
            for (int j = 2; j < split.length; j++) {
                items.add(Long.parseLong(split[j].split(",")[0]));
            }
            split = reader.data.get(i + 2).split(" ");

            monkeys[i/7] = (new Monkeys(
                    items,
                    split[4],
                    getdataint(i + 2,5),
                    getdataint(i+4,5),
                    getdataint(i+5,5),
                    getdataint(i+3,3),
                    i/7));
            limitprotectionnumber *= getdataint(i+3,3);
        }
        for (int i = 0; i < 10000;i++) {
            for (Monkeys monkeys1 : monkeys) {
                monkeys1.play();
            }
        }
        long mon1 = 0;
        long mon2 = 0;
        for (Monkeys monkeys1 : monkeys) {
            if (monkeys1.getTotalinspections() > mon1) {
                mon2 = mon1;
                mon1 = monkeys1.getTotalinspections();
                continue;
            }
            if (monkeys1.getTotalinspections() > mon2) {
                mon2 = monkeys1.getTotalinspections();
            }
        }
        System.out.println(mon1 + " " + mon2);
        System.out.println(mon1 * mon2);
    }
    private static int getdataint(int sindex,int lindex) {
        String s = reader.data.get(sindex).split(" ")[lindex];
        if (s.equals("old")) {
            return 0;
        }
        return Integer.parseInt(s);
    }
}
