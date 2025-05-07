package com.genius.webmvc.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeHandler {
    // get syskey by Genius iQ @20250507
    public  static long getSyskey() {
        return Long.parseLong(getMyanmarTimestamp());
    }

    // get current timestamp by Genius iQ @20250507
    public static String getCurrentTimestamp() {
        return getMyanmarTimestamp().substring(0, 8);
    }

    // get yyyyMMddHHmmSSS by Genius iQ @20250507
    private static String getMyanmarTimestamp() {
        ZoneId myanmarZone = ZoneId.of("Asia/Yangon");
        ZonedDateTime yangonTime = ZonedDateTime.now(myanmarZone);

        return yangonTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
    }

}
