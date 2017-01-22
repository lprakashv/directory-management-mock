package com.lpv;

import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        String inputLine = "";
        String temp = "";
        while ((inputLine = scanner.nextLine()) !=null ){
            while (!temp.equals(inputLine)) {
                temp = inputLine;
                inputLine = inputLine.replaceAll("  ", " ");
            }
            inputLine = inputLine.trim();
            if (inputLine.equalsIgnoreCase(Constants.Commands.SESSION_CLEAR)) {
                DirManager.getInstance().clearSession();
            } else {
                String[] commandWithParams = inputLine.split(" ");
                if (commandWithParams.length>0) {
                    switch (commandWithParams[0]) {
                        case Constants.Commands.CD:
                            if (commandWithParams.length==2) {
                                DirManager.getInstance().changeDir(commandWithParams[1]);
                            } else {
                                //error
                                System.out.println(Constants.ErrorMessage.CMD);
                            }
                            break;
                        case Constants.Commands.LS:
                            if (commandWithParams.length==1) {
                                DirManager.getInstance().getCurrentDir().printDirs();
                            } else {
                                //error
                                System.out.println(Constants.ErrorMessage.CMD);
                            }
                            break;
                        case Constants.Commands.MKDIR:
                            if (commandWithParams.length==2) {
                                DirManager.getInstance().createDir(commandWithParams[1]);
                            } else {
                                //error
                                System.out.println(Constants.ErrorMessage.CMD);
                            }
                            break;
                        case Constants.Commands.PWD:
                            if (commandWithParams.length==1) {
                                DirManager.getInstance().getCurrentDir().printWorkingDir();
                            } else {
                                //error
                                System.out.println(Constants.ErrorMessage.CMD);
                            }
                            break;
                        case Constants.Commands.RM:
                            if (commandWithParams.length==2) {
                                DirManager.getInstance().deleteDir(commandWithParams[1]);
                            } else {
                                //error
                                System.out.println(Constants.ErrorMessage.CMD);
                            }
                            break;
                        case "":
                            break;
                        default:
                            System.out.println(Constants.ErrorMessage.CMD);
                            break;
                    }
                }
            }
        }
    }
}
