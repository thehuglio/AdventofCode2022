//this code consists of a main and a dir class, the dir class is creating a directory system and the main class running off it
//part 1
package org.thehuglio;

import java.io.File;
import java.util.*;


public class Main {
    private static final Reader reader = new Reader(new File("data.txt"));
    private static List<String> position = new LinkedList<>();
    private static final Dir maindirectory = new Dir();
    public static int totsize = 0;

    public static void main(String[] args) {
        setMaindirectory();
        countMaindirectory();
        System.out.println(totsize);
    }
    public static void countMaindirectory() {
        maindirectory.size();
    }

    public static void setMaindirectory() {
        System.out.println(reader.data);
        for (String s : reader.data) {
            String[] split = s.split(" ");
            if (split[0].equals("$")) {
                if (split[1].equals("cd")) {
                    if (split[2].equals("/")) {
                        reset();
                    } else if (split[2].equals("..")) {
                        back();
                    } else {
                        position.add(split[2]);
                    }
                }
            } else if (split[0].equals("dir")) {
                if (position.size() != 0) {
                    List<Dir> directorylist = new LinkedList<>();
                    Dir positiondir = maindirectory;
                    for (String filename : position) {
                        positiondir = positiondir.getDir(filename);
                        directorylist.add(positiondir);
                    }
                    positiondir.addDir(split[1]);
                    directorylist.remove(directorylist.size() - 1);
                    directorylist.add(positiondir);
                    for ( int i = directorylist.size() - 1; i > 0; i--) {
                        positiondir = directorylist.get(i - 1);
                        positiondir.replaceDir(position.get(i),directorylist.get(i));
                    }
                    maindirectory.replaceDir(position.get(0),positiondir);
                } else {
                    maindirectory.addDir(split[1]);
                }
            } else {
                if (position.size() != 0) {
                    List<Dir> directorylist = new LinkedList<>();
                    Dir positiondir = maindirectory;
                    for (String filename : position) {
                        positiondir = positiondir.getDir(filename);
                        directorylist.add(positiondir);
                    }
                    positiondir.addfile(split[1], Integer.parseInt(split[0]));
                    directorylist.remove(directorylist.size() - 1);
                    directorylist.add(positiondir);
                    for ( int i = directorylist.size() - 1; i > 0; i--) {
                        positiondir = directorylist.get(i - 1);
                        positiondir.replaceDir(position.get(i),directorylist.get(i));
                    }
                    maindirectory.replaceDir(position.get(0),positiondir);
                } else {
                    maindirectory.addfile(split[1], Integer.parseInt(split[0]));
                }
            }
        }
        System.out.println(maindirectory);

    }

    private static void back() {
        position.remove(position.size() - 1);
    }

    private static void reset() {
        position = new LinkedList<>();
    }
}
package org.thehuglio;

import java.util.*;

public class Dir {
    private HashMap<String, Dir> directorys = new HashMap<>();
    private HashMap<String, Integer> files = new HashMap<>();
    private List<String> dup = new LinkedList<>();

    public void setDir(HashMap<String, Dir> map) {
        this.directorys = map;
    }

    public void addDir(String name) {
        directorys.put(name,new Dir());
    }

    public void putDir(String name, Dir d) {
        directorys.put(name,d);
    }

    public void replaceDir(String name, Dir d) {
        directorys.replace(name, d);
    }

    public Dir getDir(String name) {
        return directorys.get(name);
    }

    public void addfile(String name, int size) {
        files.put(name,size);
    }

    public int size() {
        int size = 0;
        if (directorys.size() != 0) {

            for (Map.Entry<String, Dir> directory : directorys.entrySet()) {
                size += directory.getValue().size();
                if (directory.getValue().size() <= 100000) {
                  // for part 2 change the value above to 6728267
                    if (!dup.contains(directory.getKey())){
                        dup.add(directory.getKey());
                        int dsize = directory.getValue().size();
                        Main.totsize += dsize;
                        System.out.println(directory.getKey() + " , " + dsize);
                    }
                }
            }
        }
        if (files.size() != 0) {
            for (int filessize : files.values()) {
                size += filessize;
            }
        }
        return size;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(directorys.toString()).append(files.toString());
        return stringBuilder.toString();
    }
}

