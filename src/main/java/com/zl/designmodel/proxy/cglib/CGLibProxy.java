package com.zl.designmodel.proxy.cglib;



import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


/**
 * CGLibProxy动态代理类
 * @author tzxx
 */

public class CGLibProxy implements MethodInterceptor {
    /**
     * CGLib需要代理的目标对象
     */

    private Object targetObject;
    public Object createProxyObject(Object obj) {
        //给业务对象赋值
        this.targetObject = obj;
        //创建加强器，用来创建动态代理类
        Enhancer enhancer = new Enhancer();
        //为加强器指定要代理的业务类（即：为下面生成的代理类指定父类）
        enhancer.setSuperclass(obj.getClass());
        //设置回调：对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept()方法进行拦
        enhancer.setCallback(this);
        Object proxyObj = enhancer.create();
        // 返回代理对象
        return proxyObj;
    }


    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if("say".equals(method.getName())){
            System.out.println("开始讲话");
        }
        Object obj = method.invoke(targetObject, args);
        System.out.println(proxy.getClass());
        System.out.println(methodProxy.getClass());
        return obj;

    }


    public static void main(String[] args) {
        CGLibProxy cgLibProxy = new CGLibProxy();
        User user = ( User ) cgLibProxy.createProxyObject(new User("张三"));
        user.getName();
        user.run();
        user.say();

    }
}
