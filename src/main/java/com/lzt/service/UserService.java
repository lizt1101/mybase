package com.lzt.service;


import com.lzt.domain.User;

import java.util.List;

public interface UserService {

    /**
    * 添加
    * @param user
    */
    void addUser(User user);

    /**
    * 根据主键查找
    * @param id
    */
    User getUserById(Integer id);

    User getUserInfoByUserName(String userName);

    /**
    * 根据主键批量查找
    *
    * @param list
    */
    List<User> getUsersByIds(List<Integer> list);

    /**
    * 根据主键删除
    * @param id
    */
     void deleteUserById(Integer id);

    /**
    * 根据主键更新
    * @param user
    */
    void updateUser(User user);

  /*  *//**
    列表查询
    *//*
    PageDto<User> getUserListByFilter(UserDto userDto);*/

}