package com.zl.design_model.proxy.jdk;


import java.lang.reflect.Proxy;

/**
 *
 * @author tzxx
 * @date 2018/11/28
 */
public class JdkProxy {
    public static void main(String[] args) {
        //生成$Proxy0的class文件
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
//        Student s  = new Student("张三");
//        People p1 = ( People ) Proxy.newProxyInstance(Student.class.getClassLoader(),new Class[]{People.class},new StudentProxy(s));
//        People p2 = ( People ) Proxy.newProxyInstance(Student.class.getClassLoader(),s.getClass().getInterfaces(),new StudentProxy(s));
//        p1.run();
//        System.out.println(p1.equals(p2) );

        People p3 = ( People ) Proxy.newProxyInstance(JdkProxy.class.getClassLoader(),new Class[]{People.class},new PeopleProxy());
        p3.run();
        p3.talk();

    }
}
