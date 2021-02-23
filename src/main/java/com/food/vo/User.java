package com.food.vo;

public class User {
    /**
     * 用户id，主键与业务无关
     */
    private int uid;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 性别
     */
    private String sex;
    /**
     * 出生日期
     */
    private String birthday;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 是否为管理员
     */
    private String isAdmin;
    /**
     * 是否禁用
     */
    private String isDel;
    /**
     * 头像地址
     */
    private String image;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
