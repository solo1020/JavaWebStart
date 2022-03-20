package annotation;

import org.springframework.context.annotation.Bean;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName MyBean
 * @description:
 * @author: isquz
 * @time: 2022/2/26
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Bean
public @interface MyBean {
}
