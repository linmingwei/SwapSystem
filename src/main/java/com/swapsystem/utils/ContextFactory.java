package com.swapsystem.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*单例模式加载spring-mybatis.xml配置文件生成ioc容器*/
public class ContextFactory {
    private static class ContextFactoryHolder {
        private static final ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");

    }
    private ContextFactory(){}

    public static final ApplicationContext getContext() {
        return ContextFactoryHolder.context;
    }
}
