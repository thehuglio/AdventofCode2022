//part 1
package org.thehuglio;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("data.txt");
        Reader reader = new Reader(file);
        System.out.println(reader.data);
        int sum = 0;
        for (String contents : reader.data) {
            char item = 0;
            char[] items = contents.toCharArray();
            int totalitems = items.length;
            for (int i = 0; i < totalitems/2; i++) {
                char c1 = items[i];
                for (int j = totalitems-1; j > (totalitems/2)-1; j--) {
                    if (items[j] == c1) {
                        item = items[j];
                    }
                }
            }
            sum += LetterToPrioritie(item);
        }
        System.out.println(sum);
    }
    private static int LetterToPrioritie(char s) {
        int worth = 1;
        char[] a = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        for (char b : a) {
            if (b == s) {
                return worth;
            }
            worth++;
        }
        return 0;
    }
}
//part 2
