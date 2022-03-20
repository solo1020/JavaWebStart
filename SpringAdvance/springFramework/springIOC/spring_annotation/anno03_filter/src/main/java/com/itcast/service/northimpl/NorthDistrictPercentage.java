package com.itcast.service.northimpl;

import com.itcast.annotation.District;
import com.itcast.service.DistrictPercentage;
import org.springframework.stereotype.Service;

/**
 * @ClassName NorthDistrictPercentage
 * @description: 华北区的销售分成具体实现
 * @author: isquz
 * @time: 2022/2/17 23:30
 */

@Service("districtPercentage")
@District("north")
public class NorthDistrictPercentage implements DistrictPercentage {
    /**
     * @param type
     * @description: 根据不同车辆类型计算提成
     * @param: type
     * car
     * suv
     * @return: void
     * @author: isquz
     * @date: 2022/2/17 23:27
     */
    public void salqPercentage(String type) {
        if("SUV".equalsIgnoreCase(type)){
            System.out.println("华北区" + type + "提成1%");
        }else {
            System.out.println("华北区" + type + "提成0.5%");

        }
    }
}
