package com.lzt.domain;

/**
 * @Title
 * @Description
 * @Author:lizitao
 * @Create 2018/5/14
 * @Version 1.0
 * @Copyright:2016 www.jointem.com
 */
public class RolePermission {

    private Integer id;

    private Integer roleId;

    private Integer permissionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}
