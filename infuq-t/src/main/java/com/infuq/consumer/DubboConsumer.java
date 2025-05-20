package com.infuq.consumer;


import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DubboConsumer {


    public static void main(String[] args) throws Exception {


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        BarService service = applicationContext.getBean(BarService.class);
        System.out.println(service.query("Java"));
//
//        System.out.println(service.listComputer());

//        System.in.read();

        System.out.println(service.query("C++"));

/*
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        reference.setApplication(new ApplicationConfig("infuq-dubbo-consumer"));
        reference.setRegistry(new RegistryConfig("zookeeper://zk.infuq.com:2181"));
        reference.setInterface("com.infuq.provider.FooFacade");
        reference.setVersion("1.0.0");
        reference.setGroup("infuq-t");
        reference.setGeneric("true");
        GenericService bean = reference.get();
        Object res = bean.$invoke("query", new String[] {"java.lang.String"}, new Object[] {"Java"});
        System.out.println(res);
*/



    }



}
