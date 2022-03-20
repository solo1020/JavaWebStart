package com.itcast.test;

import com.itcast.service.DistrictPercentage;
import com.itcast.service.DistrictPerformance;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName SpringFilterTest
 * @description:
 * @author: isquz
 * @time: 2022/2/20 13:36
 */
public class SpringFilterTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");

        DistrictPercentage districtPercentage = ac.getBean("districtPercentage", DistrictPercentage.class);

        districtPercentage.salqPercentage("SUV");


        DistrictPerformance districtPerformance = ac.getBean("districtPerformance", DistrictPerformance.class);
        districtPerformance.calculatePerformance("SUV");

    }

}
