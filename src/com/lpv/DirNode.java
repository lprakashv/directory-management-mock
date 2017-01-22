package com.lpv;

import java.util.*;

/**
 * Created by lpv on 22/01/17.
 */
public class DirNode {

    public DirNode () {

    }

    public DirNode (String n, DirNode p) {
        name = n;
        parent = p;
        subDirs = new TreeMap<String, DirNode>();
    }

    public String name;
    public DirNode parent;
    public Map<String, DirNode> subDirs;

    public void printWorkingDir () {
        StringBuilder sb = new StringBuilder("");
        DirNode d = this;
        while (d!=null) {
            sb.insert(0, d.name+"/");
            d = d.parent;
        }
        sb.insert(0, "PATH: ");
        System.out.println(sb.toString());
    }

    public void printDirs() {
        StringBuilder sb = new StringBuilder("");
        for (String d : this.subDirs.keySet()) {
            sb.append(d).append(" ");
        }
        sb.insert(0, "DIRS: ");
        System.out.println(sb.toString().trim());
    }
}
