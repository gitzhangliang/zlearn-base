package com.zl.spring.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author tzxx
 * @date 2019/5/9.
 */
@Configuration
@Import({ConfigBeanC.class})
public class ConfigBean {
    @Bean
    public BeanB getBeanB(){
        return new BeanB();
    }
}


