package com.itcast.service.southwestimpl;

import com.itcast.annotation.District;
import com.itcast.service.DistrictPercentage;
import org.springframework.stereotype.Service;

/**
 * @ClassName SouthwestDistrictPercentage
 * @description: 西南区分成具体实现
 * @author: isquz
 * @time: 2022/2/18 0:00
 */

@Service("districtPercentage")
@District("southwest")
public class SouthwestDistrictPercentage implements DistrictPercentage {
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
            System.out.println("西南区" + type + "提成1.5%");
        }else {
            System.out.println("西南区" + type + "提成0.5%");

        }
    }
}
