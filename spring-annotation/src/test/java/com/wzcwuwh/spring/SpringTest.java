package com.wzcwuwh.spring;

import com.wzcwuwh.spring.config.PersonConfig;
import com.wzcwuwh.spring.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class SpringTest {

    @Test
    public void testSpringXml(){
        ClassPathXmlApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person.getName() + "---" + person.getAge());
    }

    @Test
    public void testSpringAnnotation(){
        AnnotationConfigApplicationContext applicationContext = new
                AnnotationConfigApplicationContext(PersonConfig.class);
        Person person = (Person)applicationContext.getBean("myPerson");
        System.out.println(person.getName() + "---" + person.getAge());
    }

    @Test
    public void testComponentScan(){
        AnnotationConfigApplicationContext applicationContext = new
                AnnotationConfigApplicationContext(PersonConfig.class);
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        ;
    }
}
