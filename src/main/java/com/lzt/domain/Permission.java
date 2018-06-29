package com.lzt.domain;

import java.time.LocalDateTime;

/**
 * @Title
 * @Description
 * @Author:lizitao
 * @Create 2018/5/14
 * @Version 1.0
 * @Copyright:2016 www.jointem.com
 */
public class Permission {

    private Integer id;

    private String name;

    private String url;

    private Integer parentId;

    private LocalDateTime createTime;

    private String permission;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
