//part 1, this code should also work for part 2 but i cant figure out why it doesnt. so if someone knows please tell me
package org.thehuglio;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Reader reader = new Reader(new File("data.txt"));
    private static final int MaxgridSize = 1000;
    private static final int[] Tx = {MaxgridSize/2,MaxgridSize/2,MaxgridSize/2,MaxgridSize/2,MaxgridSize/2,MaxgridSize/2,MaxgridSize/2,MaxgridSize/2,MaxgridSize/2,MaxgridSize/2};
    private static final int[] Ty = {MaxgridSize/2,MaxgridSize/2,MaxgridSize/2,MaxgridSize/2,MaxgridSize/2,MaxgridSize/2,MaxgridSize/2,MaxgridSize/2,MaxgridSize/2,MaxgridSize/2};
    private static final int[][] grid = new int[MaxgridSize][MaxgridSize];

    public static void main(String[] args) {
        System.out.println(reader.data);

        for (String s : reader.data) {
            for (int i = 0; i < Integer.parseInt(s.split(" ")[1]); i++) {
                String side = s.split(" ")[0];
                switch(side) {
                    case ("U"):
                        Ty[0]--;
                        break;
                    case ("R"):
                        Tx[0]++;
                        break;
                    case ("L"):
                        Tx[0]--;
                        break;
                    case ("D"):
                        Ty[0]++;
                        break;
                }
                tailchase();

            }
        }
        for (int p = 0; p < MaxgridSize; p++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < MaxgridSize; j++) {
                stringBuilder.append(grid[j][p]).append(",");
            }
            System.out.println(stringBuilder);
        }
        System.out.println("------------------");
        int tot = 0;
        for (int i = 0; i < MaxgridSize; i++) {
            for (int j = 0; j < MaxgridSize; j++) {
                if (grid[i][j] != 0) {
                    tot++;
                }
            }
        }
        System.out.println(tot);
    }
    public static void tailchase() {
        for (int i = 1; i < 10; i++) {
            if (Tx[i - 1] == Tx[i]) {
                if (Ty[i - 1] > Ty[i] + 1) {
                    Ty[i] = Ty[i - 1] - 1;
                }
                if (Ty[i - 1] < Ty[i] - 1) {
                    Ty[i] = Ty[i - 1] + 1;
                }
            } else if (Ty[i - 1] == Ty[i]) {
                if (Tx[i - 1] > Tx[i] + 1) {
                    Tx[i] = Tx[i - 1] - 1;
                }
                if (Tx[i - 1] < Tx[i] - 1) {
                    Tx[i] = Tx[i - 1] + 1;
                }
            } else {
                if (Tx[i - 1] > Tx[i] + 1) {
                    Tx[i] = Tx[i - 1] - 1;
                    Ty[i] = Ty[i - 1];
                }
                if (Tx[i - 1] < Tx[i] - 1) {
                    Tx[i] = Tx[i - 1] + 1;
                    Ty[i] = Ty[i - 1];
                }
                if (Ty[i - 1] > Ty[i] + 1) {
                    Ty[i] = Ty[i - 1] - 1;
                    Tx[i] = Tx[i - 1];
                }
                if (Ty[i - 1] < Ty[i] - 1) {
                    Ty[i] = Ty[i - 1] + 1;
                    Tx[i] = Tx[i - 1];
                }
            }
            grid[Tx[1]][Ty[1]]++; // the number should represent the knot you are trying to trace
        }
    }
}
