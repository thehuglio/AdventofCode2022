//part 1
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
        int totalpoints = 0;
        for (String s : reader.data) {
            String[] a = s.split(" ");
            totalpoints += score(a[0],a[1]);
        }
        System.out.println(totalpoints);
    }
    private static int score(String as, String bs) {
        int ai = tonumber(as);
        int bi = tonumber(bs);
        if (ai == bi) { return bi + 3; }
        else if (ai + 1 == bi || ai - 2 == bi) { return bi + 6;}
        else {return bi;}
    }
    private static int tonumber(String s) {
        if (s.equals("A") || s.equals("X")) { return 1;}
        else if (s.equals("B") || s.equals("Y")) { return 2;}
        else {return 3;}
    }
}

//part 2
package org.thehuglio;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("data.txt");
        Reader reader =  new Reader(file);
        System.out.println(reader.data);
        int totalpoints = 0;
        for (String s : reader.data) {
            String[] a = s.split(" ");
            totalpoints += score(a[0],a[1]);
        }
        System.out.println(totalpoints);
    }
    private static int score(String as, String bs) {
        int score;
        if (bs.equals("Z")) {
            score = tonumber(as) + 1;
            if (score == 4) { score = 1;}
            return score + 6;
        }
        else if (bs.equals("Y")) {
            score = tonumber(as);
            return score + 3;
        } else {
            score = tonumber(as) - 1;
            if (score == 0) { score = 3;}
            return score;
        }
    }
    private static int tonumber(String s) {
        if (s.equals("A")) { return 1;}
        else if (s.equals("B")) { return 2;}
        else {return 3;}
    }
}
