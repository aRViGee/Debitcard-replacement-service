package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity;

import java.util.ArrayList;

public enum AuthorizationLevel {
    LEVEL_1(1),
    LEVEL_2(2),
    LEVEL_3(3);


    private Integer level;

    AuthorizationLevel(Integer level) {
        this.level = level;
    }

    public static boolean checkAllowedActions(AuthorizationLevel authorizationLevel, AllowedActions action) {
        for (AllowedActions allowedAction: AllowedActions.createAllowedActionsList(authorizationLevel)) {
            if (allowedAction.equals(action)) {
                return true;
            }
        }
        return false;
    }

    public Integer getLevel() {
        return level;
    }

}

enum AllowedActions {
    BLOCK("Block"),
    UNBLOCK("Unblock"),
    CHANGE_LIMIT("ChangeLimit"),
    REPLACE("Replace"),
    ISSUE("Issue");

    private String allowedActions;

    AllowedActions(String allowedActions) {this.allowedActions= allowedActions;}

    static ArrayList<AllowedActions> createAllowedActionsList(AuthorizationLevel authorizationLevel) {
        ArrayList<AllowedActions> actionsArrayList = new ArrayList<>();
        switch (authorizationLevel) {
            case LEVEL_1 -> {
                actionsArrayList.add(BLOCK);
                actionsArrayList.add(UNBLOCK);
            }
            case LEVEL_2 -> {
                actionsArrayList.add(BLOCK);
                actionsArrayList.add(UNBLOCK);
                actionsArrayList.add(CHANGE_LIMIT);
                actionsArrayList.add(REPLACE);
            }
            case LEVEL_3 -> {
                actionsArrayList.add(BLOCK);
                actionsArrayList.add(UNBLOCK);
                actionsArrayList.add(CHANGE_LIMIT);
                actionsArrayList.add(REPLACE);
                actionsArrayList.add(ISSUE);
            }
        }

        return actionsArrayList;
    }

}