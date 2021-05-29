//package com.zl.design_model.proxy.cglib;
//
//
//
//import org.springframework.cglib.proxy.Enhancer;
//import org.springframework.cglib.proxy.MethodInterceptor;
//import org.springframework.cglib.proxy.MethodProxy;
//
//import java.lang.reflect.Method;
//
//
///**
// * CGLibProxy动态代理类
// * @author tzxx
// */
//
//public class CGLibProxy implements MethodInterceptor {
//
//    @Override
//    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
//        Object obj = methodProxy.invokeSuper(proxy, args);
//        System.out.println(proxy.getClass());
//        System.out.println(methodProxy.getClass());
//        return obj;
//    }
//}
