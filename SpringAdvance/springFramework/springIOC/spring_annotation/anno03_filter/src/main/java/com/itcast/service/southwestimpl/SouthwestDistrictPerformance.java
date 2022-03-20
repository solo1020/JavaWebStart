package com.itcast.service.southwestimpl;

import com.itcast.annotation.District;
import com.itcast.service.DistrictPerformance;
import org.springframework.stereotype.Service;

/**
 * @ClassName SouthwestDistrictPerformance
 * @description:西南区绩效具体实现
 * @author: isquz
 * @time: 2022/2/20 13:33
 */

@Service("districtPerformance")
@District("southwest")
public class SouthwestDistrictPerformance implements DistrictPerformance {
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
            System.out.println("西南区" + type + "绩效是5");
        }else {
            System.out.println("西南区" + type + "绩效是3");

        }
    }
}
