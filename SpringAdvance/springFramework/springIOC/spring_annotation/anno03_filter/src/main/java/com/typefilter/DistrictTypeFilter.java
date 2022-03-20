package com.typefilter;

import com.itcast.annotation.District;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.filter.AbstractTypeHierarchyTraversingFilter;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.ClassUtils;
import org.springframework.util.PathMatcher;
import java.io.IOException;
import java.util.Properties;


/**
 * @ClassName DistrictTypeFilter
 * @description: 自定义扫描规则过滤器 配合自定义的注解@District进行使用
 * @author: isquz
 * @time: 2022/2/21 20:45
 */
public class DistrictTypeFilter extends AbstractTypeHierarchyTraversingFilter {

    // 定义路径校验的对象
    private PathMatcher pathMatcher;

    // 定义区域district名称 此处应该通过读取配置文件获取
    // 不能使用@Value 注解读取properties配置文件的内容
    // 因为负责填充属性值的InstantiationAwareBeanPostProcessor 与TypeFilter实例创建没有任何关系
    private String districtName;



    /**
     * @description:
     * @param: considerInherited    不考虑基类的信息
     * @param: considerInterfaces   不考虑接口的信息
     * @return:
     * @author: isquz
     * @date: 2022/2/21 20:57
     */
    protected DistrictTypeFilter() {
//        super(considerInherited, considerInterfaces);
        super(false,false);

        // 借助spring默认Resource通配符路径方式
        pathMatcher = new AntPathMatcher();

        // 读取配置文件
        try {
            Properties properties = PropertiesLoaderUtils.loadAllProperties("district.properties");
            districtName = properties.getProperty("common.district.name");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * @description: 本类将注册为Exclude 返回true表示拒绝注册
     * @param: className
     * @return: boolean
     * @author: isquz
     * @date: 2022/2/21 20:56
     */
    @Override
    protected boolean matchClassName(String className) {
//        return super.matchClassName(className);

        try {
            // 判断是否在指定包下的类 只处理与区域district相关的业务类
            if(!isPotentialPackageClass(className)){
                // 不符合路径规则
                System.out.println("not mathch specific package: " + className);
                return false;
            }
            // 判断当前区域和配置文件中的区域是否一致
            Class clazz = ClassUtils.forName(className, DistrictTypeFilter.class.getClassLoader());

            // 获取District注解
            District district = (District) clazz.getAnnotation(District.class);

            if(district == null){
                System.out.println("@District not defined");
                return false;
            }
            String districtValue = district.value();
            System.out.println("class: + " + className + " now @District value = " + districtValue);

            return (!districtName.equalsIgnoreCase(districtValue));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    // 定义 指定的package下的类 需要进行处理
    private static final String PATTERN_STANDARD =
            ClassUtils.convertClassNameToResourcePath("com.itcast.service.**");



    /**
     * @description: 本类逻辑中可以处理的类
     * @param: className
     * @return: boolean
     * @author: isquz
     * @date: 2022/2/21 22:09
     */  
    private boolean isPotentialPackageClass(String className){
        String path = ClassUtils.convertClassNameToResourcePath(className);
        System.out.println("[class] " + className + " path: " + path);
        return pathMatcher.match(PATTERN_STANDARD, path);
    }



}
