package com.wzcwuwh.spring.config;

import com.wzcwuwh.spring.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

//这里的annotation配置累相当于之前的xml配置文件
@Configuration
@ComponentScan(value = "com.wzcwuwh.spring",
//        excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)}
        useDefaultFilters = false,
        includeFilters = {
            @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)
        }
        )
public class PersonConfig {

    //@Bean注解相当于之前的<bean>标签 value相当于之前的beanId 方法名是默认的beanId 构造函数参数相当于之前的property属性
    @Bean(value = "myPerson")
    public Person person(){
        return new Person("lisi", 18);
    }
}
