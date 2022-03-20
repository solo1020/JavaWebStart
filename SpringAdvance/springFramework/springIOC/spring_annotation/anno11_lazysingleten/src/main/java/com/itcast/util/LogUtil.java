package com.itcast.util;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @ClassName LogUtil
 * @description:
 * @author: isquz
 * @time: 2022/3/14
 */

@Component
//@Scope("singleten")
@Scope("prototype")
//@Lazy
public class LogUtil {

    public LogUtil(){
        System.out.println("LogUtil object created");
    }

    public void printLog(){
        System.out.println("pring log...");
    }
}
