package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity;

public enum AuthorizationLevel {
    LEVEL_1(1),
    LEVEL_2(2),
    LEVEL_3(3);


    private Integer level;

    AuthorizationLevel(Integer level) {
        this.level = level;
    }

    public Integer getLevel() {
        return level;
    }

}
//    TODO implement allowedActions