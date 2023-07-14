package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity;

public enum Status {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    BLOCKED("Blocked"),
    EXPIRED("Expired");

    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
