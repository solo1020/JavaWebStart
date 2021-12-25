package com.itcast.service.impl;

import com.itcast.exception.MyException;
import com.itcast.service.ExceptionDemoService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @ClassName ExceptionDemoServiceImpl
 * @description:
 * @author: isquz
 * @time: 2021/12/19 0:06
 */
public class ExceptionDemoServiceImpl implements ExceptionDemoService {
    @Override
    public void classCastException() {
        System.out.println("类型转换异常...");
        Object str = "zhangsan";
        Integer num = (Integer) str;
    }

    @Override
    public void errMathException() {
        System.out.println("除零异常...");
        int i = 1/0;
    }

    @Override
    public void fileNotFoundException() throws FileNotFoundException {
        System.out.println("文件未找到异常...");
        InputStream in = new FileInputStream("C://notfound.txt");
    }

    @Override
    public void nullPointerException() {
        System.out.println("空指针异常...");
        String str = null;
        str.length();
    }

    @Override
    public void myException() throws MyException {
        System.out.println("自定义异常...");
        throw new MyException();
    }
}
