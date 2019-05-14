package com.example.justloginregistertest;

public class CommonBean {

    private int id;
    private String detailId;
    private String common;

    public CommonBean(String common) {
        this.common = common;
    }

    public CommonBean(int id, String common) {
        this.id = id;
        this.common = common;
    }

    public CommonBean(int id, String detailId, String common) {
        this.id = id;
        this.detailId = detailId;
        this.common = common;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }
}
