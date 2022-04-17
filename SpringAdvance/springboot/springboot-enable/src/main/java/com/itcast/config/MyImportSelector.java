package com.itcast.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ClassName MyImportSelector
 * @description:
 * @author: isquz
 * @time: 2022/4/17
 */
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.itcast.doamin.Role", "com.itcast.doamin.User"};
    }
}
