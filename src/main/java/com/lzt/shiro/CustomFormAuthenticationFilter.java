package com.lzt.shiro;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Title
 * @Description
 * @Author:lizitao
 * @Create 2018/5/16
 * @Version 1.0
 * @Copyright:2016 www.jointem.com
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {


    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        // 在这里进行验证码的校验

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession();

        // 取出验证码
        String validateCode = (String) session.getAttribute("image");
        // 取出页面的验证码
        // 输入的验证和session中的验证进行对比
        String randomcode = httpServletRequest.getParameter("code");
        if (randomcode != null && validateCode != null && !randomcode.equalsIgnoreCase(validateCode)) {
            // 如果校验失败，将验证码错误失败信息，通过shiroLoginFailure设置到request中
            httpServletRequest.setAttribute("shiroLoginFailure", "randomCodeError");
            // 拒绝访问，不再校验账号和密码
            return true;
        }
        return super.onAccessDenied(request, response);
    }


    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        return true;
    }


}
