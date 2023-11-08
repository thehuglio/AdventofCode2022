//part 1
package org.thehuglio;

import java.io.File;


public class Main {
    private static final Reader reader = new Reader(new File("data.txt"));

    public static void main(String[] args) {
        System.out.println(reader.data);
        int number = 0;
        for (String s : reader.data) {
            String[] values = s.split(",");
            String[] a = values[0].split("-");
            String[] b = values[1].split("-");
            if ((Integer.parseInt(b[0]) <= Integer.parseInt(a[0])
                    && Integer.parseInt(b[1]) >= Integer.parseInt(a[1]))
                    || (Integer.parseInt(a[0]) <= Integer.parseInt(b[0])
                    && Integer.parseInt(a[1]) >= Integer.parseInt(b[1]))) {
                number++;
            }
        }
        System.out.println(number);
    }
}
//part 2
package org.thehuglio;

import java.io.File;


public class Main {
    private static final Reader reader = new Reader(new File("data.txt"));

    public static void main(String[] args) {
        System.out.println(reader.data);
        int number = 0;
        for (String s : reader.data) {
            String[] values = s.split(",");
            String[] a = values[0].split("-");
            String[] b = values[1].split("-");
            if ((Integer.parseInt(a[0]) >= Integer.parseInt(b[0])
                    && Integer.parseInt(a[0]) <= Integer.parseInt(b[1]))
                    || (Integer.parseInt(a[1]) >= Integer.parseInt(b[0])
                    && Integer.parseInt(a[1]) <= Integer.parseInt(b[1]))
                    || (Integer.parseInt(b[1]) >= Integer.parseInt(a[0])
                    && Integer.parseInt(b[1]) <= Integer.parseInt(a[1]))
                    || (Integer.parseInt(b[1]) >= Integer.parseInt(a[0])
                    && Integer.parseInt(b[1]) <= Integer.parseInt(a[1]))) {
                number++;
            }
        }
        System.out.println(number);
    }
}
