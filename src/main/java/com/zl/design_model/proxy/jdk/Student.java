package com.zl.design_model.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 *
 * @author tzxx
 * @date 2018/11/28
 */
public class Student implements People {
    private String name;

    public Student(String name) {
        this.name = name;
    }
    @Override
    public void run(String address){
        System.out.println(this);
        System.out.println(name+"跑了。。。"+address);
        talk();
    }


    public void talk(){
        System.out.println(this);
        System.out.println(name+"谈论。。。");
    }

}

