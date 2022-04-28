package com.infuq.consumer;


import com.infuq.provider.BookFacade;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class QueryBookServiceImpl implements QueryBookService, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Reference(version = "1.0", group = "infuq-t", retries = 0, timeout = 50000)
    private BookFacade bookfacade;


    @Override
    public String query(String bookName) {

        BookFacade service = applicationContext.getBean(BookFacade.class);


        return bookfacade.query(bookName);

    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
