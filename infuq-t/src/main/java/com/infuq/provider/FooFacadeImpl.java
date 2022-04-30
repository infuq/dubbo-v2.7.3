package com.infuq.provider;


import org.apache.dubbo.config.annotation.Service;

@Service(timeout = 5000, version = "1.0.0", group = "infuq-t")
public class FooFacadeImpl implements FooFacade {


    @Override
    public String query(String bookName) {

        System.out.println(Thread.currentThread().getName() + "处理客户端请求");

        return "success: " + bookName;
    }


}
