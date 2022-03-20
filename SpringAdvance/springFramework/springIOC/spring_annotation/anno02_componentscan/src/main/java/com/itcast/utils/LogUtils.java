package com.itcast.utils;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @ClassName LogUtils
 * @description:
 * @author: isquz
 * @time: 2022/2/14 22:37
 */

@Component
//@Service
public class LogUtils {
    public void printLog(){
        System.out.println("printing log...");
    }
}
