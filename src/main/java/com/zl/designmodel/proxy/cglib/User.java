package com.zl.designmodel.proxy.cglib;

/**
 * Created by tzxx on 2018/11/28.
 */
public class User {
    private String name;

    public User() {
    }

    public User(String name) {

        this.name = name;
    }

    public void run(){
        System.out.println(name+"跑了。。。");
    }

    public void say(){
        System.out.println(name+"说。。。");
    }

    public String getName(){
        return name;
    }
}
