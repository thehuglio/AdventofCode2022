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

package org.thehuglio;

import java.io.File;
import java.util.List;

public class Main {
    private static final Reader reader = new Reader(new File("data.txt"));

    public static void main(String[] args) {
        System.out.println(reader.data);
        int sum = 0;
        List<String> data = reader.data;
        for (int i = 0; i < data.size();i += 3) {
            sum += search(data.get(i),data.get(i + 1),data.get(i + 2));
        }
        System.out.println(sum);
    }
    private static int search(String s1, String s2, String s3) {
        for (char c1 : s1.toCharArray()) {
            for (char c2 : s2.toCharArray()) {
                for (char c3 : s3.toCharArray()) {
                    if (c1 == c2 && c1 == c3) {
                        return LetterToPrioritie(c1);
                    }
                }
            }
        }
        return 0;
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
