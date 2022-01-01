package com.infuq.consumer;


import com.infuq.provider.BookFacade;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class QueryBookServiceImpl implements QueryBookService {

    @Reference(version = "1.0", group = "infuq-t", retries = 0, timeout = 50000)
    private BookFacade facade;


    @Override
    public String query(String bookName) {

        return facade.query(bookName);

    }


}
