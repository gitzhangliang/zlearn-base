package com.zl.design_model.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by tzxx on 2018/11/28.
 */
public class StudentProxy implements InvocationHandler {

    private Object o;
    public StudentProxy(Object o){
        this.o = o;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass()+"---");
        return method.invoke(o,args);
    }
}
