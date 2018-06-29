package com.lzt.dao;


import com.lzt.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    /**
    * 添加
    *
    * @param user
    */
    Integer addUser(User user);

    /**
    * 根据主键查找
    *
    * @param id
    */
    User getUserById(Integer id);

    /**
    * 根据主键批量查找
    *
    * @param list
    */
    List<User> getUsersByIds(List<Integer> list);

    /**
    * 根据主键删除
    *
    * @param id
    */
    Integer deleteUserById(Integer id);

    /**
    * 根据主键批量删除
    *
    * @param list
    */
    Integer deleteUserByIds(List<Integer> list);

    /**
    * 根据主键更新
    *
    * @param user
    */
    Integer updateUser(User user);

   /* *//**
        列表查询
        *//*
    List<User> getUserListByFilter(UserDo userDo);*/

    User getUserInfoByUserName(String userName);

}