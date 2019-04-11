package com.zl.designmodel.proxy.jdk;

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
    public void run(){
        System.out.println(name+"跑了。。。");
    }

    public static void main(String[] args) {
        Student s  = new Student("张三");
        People p1 = ( People ) Proxy.newProxyInstance(Student.class.getClassLoader(),new Class[]{People.class},new StudentProxy(s));
        People p2 = ( People ) Proxy.newProxyInstance(Student.class.getClassLoader(),s.getClass().getInterfaces(),new StudentProxy(s));
        p1.run();
        p2.run();
    }
}

