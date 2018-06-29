package com.lzt.config;

import com.lzt.shiro.CustomFormAuthenticationFilter;
import com.lzt.shiro.MyRealm;
import com.lzt.shiro.RetryLimitHashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Title
 * @Description
 * @Author:lizitao
 * @Create 2018/5/14
 * @Version 1.0
 * @Copyright:2016 www.jointem.com
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shirFilter(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        System.out.println("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        CustomFormAuthenticationFilter formAuthenticationFilter = new CustomFormAuthenticationFilter();
        formAuthenticationFilter.setLoginUrl("/user/login");
        formAuthenticationFilter.setUsernameParam("userName");
        formAuthenticationFilter.setPasswordParam("password");
        Map<String, Filter> filters = new HashMap<>();
        filters.put("login",formAuthenticationFilter);
        shiroFilterFactoryBean.setFilters(filters);

        //拦截器.
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/public/**", "anon");
        filterChainDefinitionMap.put("/user/login", "login");
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        // 如果不设置默认会自动寻找工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/toAdmin");

        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/error/403");


        return shiroFilterFactoryBean;
    }

    @Bean("retryLimitHashedCredentialsMatcher")
    public RetryLimitHashedCredentialsMatcher retryLimitHashedCredentialsMatcher() {
        RetryLimitHashedCredentialsMatcher retryLimitHashedCredentialsMatcher = new RetryLimitHashedCredentialsMatcher();
        retryLimitHashedCredentialsMatcher.setHashAlgorithmName("md5");
        retryLimitHashedCredentialsMatcher.setHashIterations(2);
        retryLimitHashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return retryLimitHashedCredentialsMatcher;
    }

    @Bean(name="myRealm")
    public MyRealm myShiroRealm(@Qualifier("retryLimitHashedCredentialsMatcher") RetryLimitHashedCredentialsMatcher retryLimitHashedCredentialsMatcher){
        MyRealm myRealm = new MyRealm();
        myRealm.setCredentialsMatcher(retryLimitHashedCredentialsMatcher);
        return myRealm;
    }


    @Bean(name="securityManager")
    public DefaultWebSecurityManager securityManager(@Qualifier("myRealm") MyRealm myRealm){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        return securityManager;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }




}
