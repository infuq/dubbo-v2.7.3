package com.infuq.provider;

import java.io.Serializable;

public class Computer implements Serializable {


    private String name = "电脑";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
