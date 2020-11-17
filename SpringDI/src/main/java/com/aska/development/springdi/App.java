package com.aska.development.springdi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("springContext");
        Temp temp = appContext.getBean("temp", Temp.class);
        System.out.println(temp.getName());
    }
}
