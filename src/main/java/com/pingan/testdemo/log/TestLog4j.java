package com.pingan.testdemo.log;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.log4j.NDC;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.AsyncAppender;

public class TestLog4j {
	// 初始化logger对象实例，作用域是test
    private static final Logger LOGGER = Logger.getLogger("test");
    public static void main(String[] args) {
    	// 指定配置文件
    	PropertyConfigurator.configure("./src/resources/log4j.properties");
    	
    	//打印log    	
        LOGGER.debug("debug log");	//级别低于fatal，无法打印
        LOGGER.info("info log");	//级别低于fatal，无法打印
        LOGGER.fatal("fatal log");	//可以打印
    }
}