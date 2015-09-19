package com.yoga.api;

import com.yoga.api.resources.PracticeResource;
import io.swagger.jaxrs.config.BeanConfig;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SwaggerInitialiser implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setResourcePackage(PracticeResource.class.getPackage().getName());
        beanConfig.setBasePath("http://localhost:8080/api");
        beanConfig.setScan(true);
    }
}
