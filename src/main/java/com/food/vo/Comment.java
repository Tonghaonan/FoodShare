package com.food.vo;

public class Comment {
    /**
     * 评论id
     */
    private int comId;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 评论时间
     */
    private String createTime;
    /**
     * 所属美食id
     */
    private int fid;
    /**
     * 评论用户id
     */
    private int uid;
    /**
     * 评论用户名
     */
    private String username;
    /**
     * 评论用户头像
     */
    private String image;

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
