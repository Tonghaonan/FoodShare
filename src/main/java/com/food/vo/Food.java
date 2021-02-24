package com.food.vo;

public class Food {
    /**
     * 美食ID
     */
    private int fid;
    /**
     * 发布者ID
     */
    private int uid;
    /**
     * 美食名称
     */
    private String fname;
    /**
     * 美食介绍
     */
    private String detail;
    /**
     * 所属类别
     */
    private int cid;
    /**
     * 美食图片地址
     */
    private String image;
    /**
     * 推荐星级
     */
    private int star;
    /**
     * 创建时间
     */
    private String createTime;

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
