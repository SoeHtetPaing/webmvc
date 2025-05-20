package com.genius.webmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    long syskey;
    long autokey;
    String createddate;
    String modifieddate;
    String createduser;
    String modifieduser;
    int recordstatus;
    String t1;
    String t2;
}
