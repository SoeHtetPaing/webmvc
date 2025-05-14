package com.genius.webmvc.util;

public class CommonHandler {
    // get syskey by Genius iQ @20250507
    public  static long getSyskey() {
        return Long.parseLong(DateTimeHandler.getMyanmarTimestamp());
    }
}
