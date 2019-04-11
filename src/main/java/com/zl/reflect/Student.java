package com.zl.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author tzxx
 */
public class Student {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) throws Exception {
        //通过反射获取类
        Class<Student> studentClass = Student.class;
        //获取构造时,需要传入的该构造的参数类型
        Class[] classes = new Class[]{String.class, int.class};
        //获取类的参数为String和int类型的public构造函数
        Constructor constructor = studentClass.getConstructor(classes);
        //通过构造参数创建一个Student类的实例
        Student zhangsan = ( Student ) constructor.newInstance("张三", 18);
        //获取Student对象里名字为“getName”的方法
        Method method = studentClass.getMethod("getName", new Class[]{});
        //执行方法哪个实例的"getName"方法
        String name = ( String ) method.invoke(zhangsan, new Object[]{});
        //打印我们创建实例对象时传入的name,看是否能通过"getName"方法获取到
        System.out.println("name = " + name);
    }
} 

