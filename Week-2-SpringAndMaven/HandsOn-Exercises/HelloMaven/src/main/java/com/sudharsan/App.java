package com.sudharsan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("1");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("Application Started successfully!");
        System.out.println("2");
        
        // userRepository is the beanId that we have given in the XML configurations.
        UserRepository userRepository1 = context.getBean("userRepository",UserRepository.class);
        System.out.println(userRepository1);

        UserRepository userRepository2 = context.getBean("userRepository",UserRepository.class);
        System.out.println(userRepository2);

        if(userRepository1 == userRepository2){
            System.out.println("Same object");
        }
        if(userRepository1.equals(userRepository2)){
            System.out.println("Same object");
        }
    }
}
