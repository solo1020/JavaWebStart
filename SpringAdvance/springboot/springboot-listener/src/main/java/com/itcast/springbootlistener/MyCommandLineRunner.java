package com.itcast.springbootlistener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @ClassName MyCommandLineRunner
 * @description:
 * @author: isquz
 * @time: 2022/4/18
 */

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner...");
        System.out.println(Arrays.toString(args));
    }
}
