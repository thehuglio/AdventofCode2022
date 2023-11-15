package org.thehuglio;

import java.io.File;
import java.util.*;

public class Main {
    private static final Reader reader = new Reader(new File("data.txt"));
    public static int x = reader.data.get(1).toCharArray().length;
    public static int y = reader.data.size();
    public static int[][] hgrid = new int[x][y];
    public static int[][] sgrid = new int[x][y];


    public static void main(String[] args) {
        int endx = 0;
        int endy = 0;
        System.out.println(reader.data);
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (reader.data.get(i).toCharArray()[j] == 'a') { // change 'a' to 'S' for part 1
                    hgrid[j][i] = 1;
                    sgrid[j][i] = 1;
                }else if (reader.data.get(i).toCharArray()[j] == 'E') {
                    hgrid[j][i] = 26;
                    endx = j;
                    endy = i;
                } else {
                    String index = reader.data.get(i).split("")[j];
                    String[] c = "abcdefghijklmnopqrstuvwxyz".split("");
                    hgrid[j][i] = Arrays.asList(c).indexOf(index) + 1;
                }
            }
        }
        int check = 0;
        while (check<100) {
            for (int y = 0; y < Main.y; y++) {
                for (int x = 0; x < Main.x; x++) {
                    if (x != 0) {
                        if ((sgrid[x - 1][y] < sgrid[x][y] || sgrid[x][y] == 0) && hgrid[x - 1][y] + 1 >= hgrid[x][y] && sgrid[x - 1][y] != 0) {
                            sgrid[x][y] = sgrid[x - 1][y] + 1;
                        }
                    }
                    if (x != Main.x - 1) {
                        if ((sgrid[x + 1][y] < sgrid[x][y] || sgrid[x][y] == 0) && hgrid[x + 1][y] + 1 >= hgrid[x][y] && sgrid[x + 1][y] != 0) {
                            sgrid[x][y] = sgrid[x + 1][y] + 1;
                        }
                    }
                    if (y != 0) {
                            if ((sgrid[x][y - 1] < sgrid[x][y] || sgrid[x][y] == 0) && hgrid[x][y - 1] + 1 >= hgrid[x][y] && sgrid[x][y - 1] != 0) {
                                sgrid[x][y] = sgrid[x][y - 1] + 1;
                            }
                    }
                    if (y != Main.y - 1) {
                        if ((sgrid[x][y + 1] < sgrid[x][y] || sgrid[x][y] == 0) && hgrid[x][y + 1] + 1 >= hgrid[x][y] && sgrid[x][y + 1] != 0) {
                            sgrid[x][y] = sgrid[x][y + 1] + 1;
                        }
                    }
                }
            }
            for (int y = 0; y < Main.y; y++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int x = 0; x < Main.x; x++) {
                    if (sgrid[x][y] < 10) {
                        stringBuilder.append(0);
                    }
                    if (sgrid[x][y] < 100) {
                        stringBuilder.append(0);
                    }
                    stringBuilder.append(sgrid[x][y]);
                    stringBuilder.append(" ");
                }
                System.out.println(stringBuilder);
            }
            if (sgrid[endx][endy] != 0) {
                System.out.println(sgrid[endx][endy] - 1);
                check++;
            }
        }
    }
}
