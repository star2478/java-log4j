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

public class TestNDCofLog4j {
	// 初始化logger对象实例，作用域是test
    private static final Logger LOGGER = Logger.getLogger(TestNDCofLog4j.class);
    public static void main(String[] args) {
    	// 指定配置文件
    	PropertyConfigurator.configure("./src/resources/log4j.properties");
    	
    	// 将数据push进NDC stack
    	NDC.push("test1");
    	NDC.push("test2");
    	NDC.push("test3");
    	
    	// 将NDC末尾数据pop出NDC stack
    	NDC.pop();	// 此时test3会被清除出NDC
    	
    	//打印log    	
        LOGGER.info("info log");
        String str1='a',str2='b';
        
        // 第一种情况：
        LOGGER.debug("log:" + str1 + str2);
        // 第二种情况：需要进行if判定
        if (LOGGER.isDebugEnabled ()) {
        	LOGGER.debug("log:" + str1 + str2);
        }

    }
}