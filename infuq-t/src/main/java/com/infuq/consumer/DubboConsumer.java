package com.infuq.consumer;


import com.infuq.provider.BookFacade;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DubboConsumer {


    public static void main(String[] args) throws Exception {


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        QueryBookService service = applicationContext.getBean(QueryBookService.class);

        System.out.println(service.query("Java"));


        System.out.println("xyz");
//        System.in.read();

        System.out.println(service.query("C++ Python"));

        System.out.println("123");

    }



}
