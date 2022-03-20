package com.itcast.service.northimpl;

import com.itcast.annotation.District;
import com.itcast.service.DistrictPerformance;
import org.springframework.stereotype.Service;

/**
 * @ClassName NorthDistrictPerformance
 * @description: 华北区绩效计算具体实现
 * @author: isquz
 * @time: 2022/2/17 23:33
 */

@Service("districtPerformance")
@District("north")
public class NorthDistrictPerformance implements DistrictPerformance {
    /**
     * @param type
     * @description: 根据不同车辆类型计算绩效
     * @param: type
     * car
     * suv
     * @return: void
     * @author: isquz
     * @date: 2022/2/17 23:29
     */
    public void calculatePerformance(String type) {
        if("SUV".equalsIgnoreCase(type)){
            System.out.println("华北区" + type + "绩效是3");
        }else {
            System.out.println("华北区" + type + "绩效是5");

        }
    }
}
