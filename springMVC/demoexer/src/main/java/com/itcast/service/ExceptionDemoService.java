package com.itcast.service;

import com.itcast.exception.MyException;

import java.io.FileNotFoundException;

/**
 * @ClassName ExceptionDemoService
 * @description:
 * @author: isquz
 * @time: 2021/12/19 0:05
 */
public interface ExceptionDemoService {
    void classCastException();

    void errMathException();

    void fileNotFoundException() throws FileNotFoundException;

    void nullPointerException();

    void myException() throws MyException;
}
