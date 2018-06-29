package com.lzt.service.impl;

import com.lzt.dao.UserDao;
import com.lzt.domain.User;
import com.lzt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void addUser(User user){

        userDao.addUser( user);
    }


    @Override
    public User getUserById(Integer id){

        return checkUser(id);
    }

    private User checkUser(Integer id){
        User user = userDao.getUserById(id);
        if(user ==null){

        }
        return user;
    }


    @Override
    public List<User> getUsersByIds(List<Integer> list){

        return userDao.getUsersByIds(list);
    }


    @Override
    public void deleteUserById(Integer id){
        checkUser(id);
        userDao.deleteUserById(id);
    }


    @Override
    public void updateUser(User user){
        checkUser( user.getId() );
        userDao.updateUser(user);
    }

    @Override
    public User getUserInfoByUserName(String userName) {
        return userDao.getUserInfoByUserName(userName);
    }

    /*@Override
    public PageDto<User> getUserListByFilter(UserDto userDto){
        PageHelper.startPage(userDto.getPageNum(),userDto.getPageSize());
        List<User> list = userDao.getUserListByFilter( userDto);
        PageInfo pageInfo = new PageInfo(list);
        PageDto pageDto = new PageDto(pageInfo,list);
        return pageDto;
    };*/

}