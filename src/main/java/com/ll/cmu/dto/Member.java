package com.ll.cmu.dto;

import java.time.LocalDateTime;

public class Member {
    private int id;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private String username;
    private String password;
    private String email;
    private MemberStatus adminLevel;


}
