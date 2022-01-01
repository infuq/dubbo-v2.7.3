package com.infuq.provider;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DubboProvider {


    public static void main(String[] args) throws Exception {


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("服务端启动完成...");

        System.in.read();

    }



}
