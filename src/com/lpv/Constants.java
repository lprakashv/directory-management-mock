package com.lpv;

/**
 * Created by lpv on 22/01/17.
 */
public class Constants {
    public class Commands {
        public static final String PWD = "pwd";
        public static final String LS = "ls";
        public static final String CD = "cd";
        public static final String RM = "rm";
        public static final String MKDIR = "mkdir";
        public static final String SESSION_CLEAR = "session clear";
    }

    public class ErrorMessage {
        public static final String CMD = "ERR: CANNOT RECOGNIZE INPUT";
        public static final String RM_ROOT = "ERR: ROOT CANNOT BE DELETED";
        public static final String INVALID_PATH = "ERR: INVALID PATH";
        public static final String MKDIR_BLANK = "ERR: BLANK DIRECTORY NAME";
    }

    public class SuccessMessages {
        public static final String MKDIR = "SUCC: CREATED";
        public static final String CD = "SUCC: REACHED";
        public static final String RM = "SUCC: DELETED";
        public static final String RM_CHANGED_DIR = "SUCC: DELETED CURRENT DIR, CHANGED TO ROOT";
        public static final String SESS_CLEAR = "SUCC: CLEARED: RESET TO ROOT";
    }
}
