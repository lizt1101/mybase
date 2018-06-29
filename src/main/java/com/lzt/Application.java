package com.lzt;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Title
 * @Description
 * @Author:lizitao
 * @Create 2018/5/23
 * @Version 1.0
 * @Copyright:2016 www.jointem.com
 */
public class Application extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MybaseApplication.class);
    }
}
