package com.lzt.controller;

import java.lang.Integer;
import com.alibaba.fastjson.JSON;
import com.lzt.ResponseVo;
import com.lzt.domain.User;
import com.lzt.service.UserService;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController{

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/test",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public void test(HttpServletRequest request, HttpServletResponse response){
        System.out.println("测试12345");
    }

    @GetMapping(value = "/login",produces = "application/json;charset=utf-8")
    public String login1(HttpServletRequest request, HttpServletResponse response) {
        return "redirect:/toLogin";
    }
    /**
     * 登陆
     * @param
     * @return
     */
    @PostMapping(value = "/login",produces = "application/json;charset=utf-8")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        ResponseVo responseVo = new ResponseVo();
        LOG.info("登陆");
        String exception = (String) request.getAttribute("shiroLoginFailure");
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                request.setAttribute("error","账号不存在");
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                request.setAttribute("error","密码不正确");
            }else if ("randomCodeError".equals(exception)) {
                request.setAttribute("error","验证码错误");
            }else if(ExcessiveAttemptsException.class.getName().equals(exception)){
                request.setAttribute("error","登陆次数过多，请10分钟后再重试");
            }else {
                request.setAttribute("error","未知错误");
            }
            return "login";
        }
        return "redirect:/toAdmin";
    }




    /**
    * 添加用户
    */
    @PostMapping(value = "/add",produces = "application/json;charset=utf-8")
    public String addUser(@RequestBody String param) {
        ResponseVo responseVo = new ResponseVo();
        LOG.info("入参为："+ param);
        User user = JSON.parseObject(param,User.class);
        userService.addUser(user);
        return responseVo.toString();
    }

    /**
    * 详情
    */
    @PostMapping(value = "/getInfo",produces = "application/json;charset=utf-8")
    public String getUserInfo(Integer id) {
        LOG.info("详情，入参为："+ id);
        ResponseVo responseVo = new ResponseVo();
        if(id ==null){

        }
        responseVo.setData(userService.getUserById(id));
        return responseVo.toString();
    }


    /**
    * 编辑
    */
    @PostMapping(value = "/update",produces = "application/json;charset=utf-8")
    public String updateUser(@RequestBody String param) {
        LOG.info("编辑入参为："+ param);
        User user = JSON.parseObject(param,User.class);
        ResponseVo responseVo = new ResponseVo();
        if (user.getId() ==null){

        }
        userService.updateUser(user);
        return responseVo.toString();
    }


    /**
    * 列表
    */
   /* @PostMapping(value = "/getList",produces = "application/json;charset=utf-8")
    public String getUserList(@RequestBody String param) {
        LOG.info("列表,入参为："+ param);
        UserDto userDto = JSON.parseObject(param,UserDto.class);
        return ResponseUtil.Success(userService.getUserListByFilter(userDto));
    }
*/

}