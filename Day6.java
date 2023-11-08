//part 1
package org.thehuglio;

import java.io.File;


public class Main {
    private static final Reader reader = new Reader(new File("data.txt"));

    public static void main(String[] args) {
        System.out.println(reader.data);
        char c1 = 0;
        char c2 = 0;
        char c3 = 0;
        char c4 = 0;
        int counter = -1;
        for (char c : reader.data.get(0).toCharArray()) {
            counter++;
            if (c == c1 || c == c2 || c == c3 || c == c4 || c1 == c2 || c1 == c3 || c1 == c4 || c2 == c3 || c2 == c4 || c3 == c4 || c4 == 0) {
                c4 = c3;
                c3 = c2;
                c2 = c1;
                c1 = c;
            } else {
                System.out.println(counter);
                break;
            }
        }
    }
}
//part 2
