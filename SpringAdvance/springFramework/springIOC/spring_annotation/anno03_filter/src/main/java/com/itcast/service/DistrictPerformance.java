package com.itcast.service;

/**
 * @ClassName DistrictPerformance
 * @description: 绩效计算的桥接接口
 * @author: isquz
 * @time: 2022/2/17 23:28
 */
public interface DistrictPerformance {
    
    /**
     * @description:  根据不同车辆类型计算绩效
     * @param: type
     *      car
     *      suv
     *
     * @return: void
     * @author: isquz
     * @date: 2022/2/17 23:29
     */  
    void calculatePerformance(String type);
}
