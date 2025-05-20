package com.infuq.provider;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.misc.SignalHandler;

public class DubboProvider {


    public static void main(String[] args) throws Exception {


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("自定义钩子方法");
        }));


        System.out.println("服务端启动完成...");

        System.in.read();

    }



}
