package com.itcast.service;

/**
 * @ClassName DistrictPercentage
 * @description: 销售分成的桥接接口
 * @author: isquz
 * @time: 2022/2/17 23:27
 */
public interface DistrictPercentage {
    
    /**
     * @description: 根据不同车辆类型计算提成
     * @param: type
     *      car
     *      suv
     * @return: void
     * @author: isquz
     * @date: 2022/2/17 23:27
     */  
    void salqPercentage(String type);
    
}
