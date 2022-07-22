package com.ll.cmu.dto;

public enum MemberStatus {
    USER("3"), ADMIN("6");

    private final String level;

    MemberStatus(String level) {
        this.level = level;
    }

    public String getLevel(){
        return level;
    }
}
