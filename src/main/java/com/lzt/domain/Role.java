package com.lzt.domain;

/**
 * @Title
 * @Description
 * @Author:lizitao
 * @Create 2018/5/14
 * @Version 1.0
 * @Copyright:2016 www.jointem.com
 */
public class Role {

    private Integer id;

    private String name;

    private Integer isUse;

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

    public Integer getIsUse() {
        return isUse;
    }

    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
    }
}
