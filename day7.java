// this code again consists out of 2 classes, the Safedoubleints safes 2 list of ints
package org.thehuglio;

import java.util.LinkedList;
import java.util.List;

public class Safedoubleints {
    List<Integer> one = new LinkedList<>();
    List<Integer> two = new LinkedList<>();
    public void put(int one, int two) {
        this.one.add(one);
        this.two.add(two);
    }
    public int size() {
        return one.size();
    }
    public Boolean contains(int x,int y) {
        for (int i = 0; i < one.size(); i++) {
            if (one.get(i) == x && two.get(i) == y) {
                return true;
            }
        }
        return false;
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < one.size(); i++) {
            s.append(one.get(i)).append(",").append(two.get(i)).append("\n");
        }
        return s.toString();
    }
}
//part 1
package org.thehuglio;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Reader reader = new Reader(new File("data.txt"));
    private static int [][] forest;
    private static Safedoubleints safedints = new Safedoubleints();

    public static void main(String[] args) {
        System.out.println(reader.data);
        int xas = reader.data.get(0).toCharArray().length;
        int yas = reader.data.size();
        forest = new int[yas][xas];
        for (int i = 0; i < yas; i++) {
            char[] chars = reader.data.get(i).toCharArray();
            for (int j = 0; j < xas; j++) {
                forest[j][i] = Integer.parseInt(String.valueOf(chars[j]));
            }
        }
        for (int i = 0; i < xas; i++) {
            int biggest = -1;
            for (int j = 0; j < yas; j++) {
                if (forest[i][j] > biggest) {
                    biggest = forest[i][j];
                    if (!safedints.contains(i,j)) {
                        safedints.put(i,j);
                    }
                }
            }
        }
        System.out.println(safedints);
        System.out.println("finished 1");
        for (int i = 0; i < xas; i++) {
            int biggest = -1;
            for (int j = yas - 1; j >= 0; j--) {
                if (forest[i][j] > biggest) {
                    biggest = forest[i][j];
                    if (!safedints.contains(i,j)) {
                        safedints.put(i,j);
                    }
                }
            }
        }
        System.out.println(safedints);
        System.out.println("finished 2");
        for (int j = 0; j < yas; j++) {
            int biggest = -1;
            for (int i = 0; i < xas; i++) {
                if (forest[i][j] > biggest) {
                    biggest = forest[i][j];
                    if (!safedints.contains(i,j)) {
                        safedints.put(i,j);
                    }
                }
            }
        }
        System.out.println(safedints);
        System.out.println("finished 3");
        for (int j = 0; j < yas; j++) {
            int biggest = -1;
            for (int i = xas - 1; i >= 0; i--) {
                if (forest[i][j] > biggest) {
                    biggest = forest[i][j];
                    if (!safedints.contains(i,j)) {
                        safedints.put(i,j);
                    }
                }
            }
        }
        System.out.println("finished 4");
        System.out.println(safedints);
        System.out.println(safedints.size());
    }
}
// part 2
package org.thehuglio;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Reader reader = new Reader(new File("data.txt"));
    private static int [][] forest;
    private static Safedoubleints safedints = new Safedoubleints();

    public static void main(String[] args) {
        System.out.println(reader.data);
        int xas = reader.data.get(0).toCharArray().length;
        int yas = reader.data.size();
        forest = new int[yas][xas];
        for (int i = 0; i < yas; i++) {
            char[] chars = reader.data.get(i).toCharArray();
            for (int j = 0; j < xas; j++) {
                forest[j][i] = Integer.parseInt(String.valueOf(chars[j]));
            }
        }
        int biggest = 0;
        for (int i = 1; i < xas; i++) {
            for (int j = 1; j < yas; j++) {
                int sight = sight(i,j);
                if (sight > biggest) {
                    biggest = sight;
                }
            }
        }
        System.out.println(biggest);
    }
    public static int sight(int x, int y) {
        int sight = 1;
        int s = 0;
        int size = forest[x][y];
        for (int i = x - 1; i > -1; i--) {
            if (size > forest[i][y]) {
                s++;
            } else {
                s++;
                break;
            }
        }
        sight *= s;
        s = 0;
        for (int i = x + 1; i < reader.data.get(0).toCharArray().length; i++) {
            if (size > forest[i][y]) {
                s++;
            } else {
                s++;
                break;
            }
        }
        sight *= s;
        s = 0;
        for (int i = y - 1; i > -1; i--) {
            if (size > forest[x][i]) {
                s++;
            } else {
                s++;
                break;
            }
        }
        sight *= s;
        s = 0;
        for (int i = y + 1; i < reader.data.size(); i++) {
            if (size > forest[x][i]) {
                s++;
            } else {
                s++;
                break;
            }
        }
        sight *= s;
        return sight;
    }
}
