package com.lzt.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class User implements Serializable {
    /** 主键 id*/
    private Integer id;
    /**用户名*/
    private String userName;
    /**密码*/
    private String password;
    /**0-可登陆 1-禁止登陆*/
    private Integer status;
    /**0-否 1-是*/
    private Integer isDelete;
    /**创建时间*/
    private LocalDateTime createTime;
    /**更新时间*/
    private LocalDateTime updateTime;
    /**签名*/
    private String signature;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}