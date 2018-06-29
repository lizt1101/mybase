package com.lzt.controller;

import com.lzt.util.ImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Title
 * @Description
 * @Author:lizitao
 * @Create 2018/5/3
 * @Version 1.0
 * @Copyright:2016 www.jointem.com
 */
@Controller
public class BaseController {

    @RequestMapping("/")
    public String init(){
        return "test";
    }

    @RequestMapping("/toAdmin")
    public String toAdmin(){
        return "admin/index";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/public/403")
    public String to403(){
        return "/error/403";
    }

    @RequestMapping(value={"/public/getCode"})
    public void getImage(HttpServletRequest req, HttpServletResponse res) throws IOException {
        //生成验证码及图片
        Object[] objs = ImageUtil.createImage();
        //验证码存入session
        HttpSession session = req.getSession();
        session.setAttribute("image", objs[0]);
        //将图片输出给浏览器
        res.setContentType("image/png");
        //获取输出流,该流由服务器自动创建,
        //它所输出的目标就是当前访问的浏览器.
        OutputStream os = res.getOutputStream();
        BufferedImage img =
                (BufferedImage) objs[1];
        ImageIO.write(img, "png", os);
        os.close();
    }


}
