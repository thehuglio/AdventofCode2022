package org.thehuglio;

import javax.swing.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {

    private static final List<String> data = new Reader(new File("data.txt")).data;


    public static void main(String[] args) {
        List<String> left;
        List<String> right;
        int tot = 0;
        int in = 0;
        for (int i = 0; i < data.size(); i+=3) {
            left = Arrays.asList(data.get(i).split(""));
            right = Arrays.asList(data.get(i+1).split(""));
            int indicatorleft = 0;
            int indicatorright = 0;
            while  (true) {
                in++;
                if (Objects.equals(left.get(indicatorleft), "]") && Objects.equals(right.get(indicatorright),"]")) {
                    indicatorleft++;
                    indicatorright++;
                    continue;
                } else if (Objects.equals(left.get(indicatorleft), "]")) {

                } else {
                    if ((Integer.parseInt(left.get(indicatorleft)) <= Integer.parseInt(right.get(indicatorright)))) {
                        indicatorleft++;
                        indicatorright++;
                        continue;
                    } else {
                        break;
                    }
                }
            }
        }

    }
}
//not done yet
