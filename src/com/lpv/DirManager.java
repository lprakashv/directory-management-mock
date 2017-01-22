package com.lpv;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lpv on 22/01/17.
 */
public class DirManager {

    private static DirManager instance;

    private DirNode currentDir = null;
    private DirNode root = null;

    private DirManager() {}

    public static DirManager getInstance() {
        if (instance==null) {
            synchronized (DirManager.class) {
                if (instance==null) {
                    instance = new DirManager();
                    DirNode newDir = new DirNode("", null);
                    instance.root = newDir;
                    instance.currentDir = instance.root;
                }
            }
        }
        return instance;
    }

    public void clearSession() {
        instance = null;
        System.out.println(Constants.SuccessMessages.SESS_CLEAR);
    }

    public static void setInstance(DirManager instance) {
        DirManager.instance = instance;
    }

    public DirNode getCurrentDir() {
        return currentDir;
    }

    public void setCurrentDir(DirNode currentDir) {
        this.currentDir = currentDir;
    }

    public void createDir(String param) {
        if (param.charAt(param.length()-1)=='/') {
            param = param.substring(0, param.length()-1);
        }
        String[] dirs = param.split("/");
        DirNode tempDir = null;
        int i;
        if (dirs.length>0 && dirs[0].equals("..")) {
            tempDir = currentDir.parent;
            i=1;
        } else if (param.charAt(0) == '/') {
            tempDir = root;
            i=1;
        } else if (param.charAt(0) == '.') {
            tempDir = currentDir;
            i=1;
        } else {
            tempDir = currentDir;
            i=0;
        }
        for (; i<dirs.length-1; i++) {
            if (tempDir.subDirs.get(dirs[i])!=null) {
                tempDir = tempDir.subDirs.get(dirs[i]);
            } else {
                System.out.println(Constants.ErrorMessage.INVALID_PATH);
                return;
            }
        }
        String newDirName = dirs[dirs.length-1];
        if (newDirName.trim().length()>0) {
            DirNode newDir = new DirNode(newDirName, tempDir);
            tempDir.subDirs.put(newDir.name, newDir);
            System.out.println(Constants.SuccessMessages.MKDIR);
        } else {
            System.out.println(Constants.ErrorMessage.MKDIR_BLANK);
        }
    }

    public void changeDir(String param) {
        if (param.charAt(param.length()-1)=='/') {
            param = param.substring(0, param.length()-1);
        }
        String[] dirs = param.split("/");
        DirNode tempDir = null;
        int i;
        if (dirs.length>0 && dirs[0].equals("..")) {
            tempDir = currentDir.parent;
            i=1;
        } else if (param.charAt(0) == '/') {
            tempDir = root;
            i=1;
        } else if (param.charAt(0) == '.') {
            tempDir = currentDir;
            i=1;
        } else {
            tempDir = currentDir;
            i=0;
        }
        for (;i<dirs.length; i++) {
            if (tempDir.subDirs.get(dirs[i])!=null) {
                tempDir = tempDir.subDirs.get(dirs[i]);
            } else {
                System.out.println(Constants.ErrorMessage.INVALID_PATH);
                return;
            }
        }
        currentDir = tempDir;
        System.out.println(Constants.SuccessMessages.CD);
    }

    public void deleteDir(String param) {
        if (param.charAt(param.length()-1)=='/') {
            param = param.substring(0, param.length()-1);
        }
        String[] dirs = param.split("/");
        DirNode tempDir = null;
        int i;
        if (dirs.length>0 && dirs[0].equals("..")) {
            tempDir = currentDir.parent;
            i=1;
        } else if (param.charAt(0) == '/') {
            tempDir = root;
            i=1;
        } else if (param.charAt(0) == '.') {
            tempDir = currentDir;
            i=1;
        } else {
            tempDir = currentDir;
            i=0;
        }
        for (;i<dirs.length; i++) {
            if (tempDir.subDirs.get(dirs[i])!=null) {
                tempDir = tempDir.subDirs.get(dirs[i]);
            } else {
                System.out.println(Constants.ErrorMessage.INVALID_PATH);
                return;
            }
        }
        if (tempDir == root) {
            System.out.println(Constants.ErrorMessage.RM_ROOT);
            return;
        }
        tempDir.parent.subDirs.remove(tempDir.name);
        if (currentDir==tempDir) {
            currentDir=root;
            System.out.println(Constants.SuccessMessages.RM_CHANGED_DIR);
        } else {
            System.out.println(Constants.SuccessMessages.RM);
        }
    }
}
