//part 1 (maybe one of my less pritty code)
package org.thehuglio;

import java.io.File;
import java.util.Arrays;


public class Main {
    private static final Reader reader = new Reader(new File("data.txt"));

    public static void main(String[] args) {
        System.out.println(reader.data);
        String[][] containers = creator();
        for (String s : reader.data) {
            String[] splited = s.split(" ");
            int move = Integer.parseInt(splited[1]);
            int from = Integer.parseInt(splited[3]) - 1;
            int to = Integer.parseInt(splited[5]) - 1;
            for (int i = 0; i < move; i++) {
                StringBuilder s1 = new StringBuilder();
                StringBuilder s2 = new StringBuilder();
                String safe = containers[from][0];
                for (int j = 1; j < containers[from].length;j++) {
                    s1.append(containers[from][j] + " ");
                }
                s2.append(safe + " ");
                for (int j = 0; j < containers[to].length;j++) {
                    s2.append(containers[to][j] + " ");
                }
                containers[from] = s1.toString().split(" ");
                containers[to] = s2.toString().split(" ");
            }
        }
        System.out.println(Arrays.deepToString(containers));
    }
    private static String[][] creator() {
        String[] row1 = {"N", "R", "J", "T", "Z", "B", "D", "F"};
        String[] row2 = {"H", "J", "N", "S", "R"};
        String[] row3 = {"Q", "F", "Z", "G", "J", "N", "R", "C"};
        String[] row4 = {"Q", "T", "R", "G", "N", "V", "F"};
        String[] row5 = {"F", "Q", "T", "L"};
        String[] row6 = {"N", "G", "R", "B", "Z", "W", "C", "Q"};
        String[] row7 = {"M", "H", "N", "S", "L", "C", "F"};
        String[] row8 = {"J", "T", "M", "Q", "N", "D"};
        String[] row9 = {"S", "G", "P"};

        return new String[][]{row1, row2, row3, row4, row5, row6, row7, row8, row9};
    }
}
//part 2
package org.thehuglio;

import java.io.File;
import java.util.Arrays;


public class Main {
    private static final Reader reader = new Reader(new File("data.txt"));

    public static void main(String[] args) {
        System.out.println(reader.data);
        String[][] containers = creator();
        for (String s : reader.data) {
            String[] splited = s.split(" ");
            int move = Integer.parseInt(splited[1]);
            int from = Integer.parseInt(splited[3]) - 1;
            int to = Integer.parseInt(splited[5]) - 1;

            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder();
            StringBuilder safe = new StringBuilder();
            for (int j = 0; j < move; j++) {
                if (j < containers[from].length) {
                    safe.append(containers[from][j]).append(" ");
                }
            }
            for (int j = move; j < containers[from].length;j++) {
                s1.append(containers[from][j]).append(" ");
            }
            s2.append(safe);
            for (int j = 0; j < containers[to].length;j++) {
                s2.append(containers[to][j]).append(" ");
            }
            containers[from] = s1.toString().split(" ");
            containers[to] = s2.toString().split(" ");
        }
        System.out.println(Arrays.deepToString(containers));
    }
    private static String[][] creator() {
        String[] row1 = {"N", "R", "J", "T", "Z", "B", "D", "F"};
        String[] row2 = {"H", "J", "N", "S", "R"};
        String[] row3 = {"Q", "F", "Z", "G", "J", "N", "R", "C"};
        String[] row4 = {"Q", "T", "R", "G", "N", "V", "F"};
        String[] row5 = {"F", "Q", "T", "L"};
        String[] row6 = {"N", "G", "R", "B", "Z", "W", "C", "Q"};
        String[] row7 = {"M", "H", "N", "S", "L", "C", "F"};
        String[] row8 = {"J", "T", "M", "Q", "N", "D"};
        String[] row9 = {"S", "G", "P"};

        return new String[][]{row1, row2, row3, row4, row5, row6, row7, row8, row9};
    }
}
