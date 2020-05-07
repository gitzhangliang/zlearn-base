package com.zl.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author zhangliang
 * @date 2020/5/7.
 */
public class ReflectTest {
    @Test
    public void test0() throws Exception {
        //通过反射获取类
        Class<Student> studentClass = Student.class;
        //获取构造时,需要传入的该构造的参数类型
        Class[] classes = new Class[]{String.class, int.class};
        //获取类的参数为String和int类型的public构造函数
        Constructor constructor = studentClass.getConstructor(classes);
        //通过构造参数创建一个Student类的实例
        Student zhangsan = ( Student ) constructor.newInstance("张三", 18);
        //获取Student对象里名字为“getName”的方法
        Method method = studentClass.getMethod("getName");
        //执行方法哪个实例的"getName"方法
        String name = ( String ) method.invoke(zhangsan);
        //打印我们创建实例对象时传入的name,看是否能通过"getName"方法获取到
        System.out.println("name = " + name);
    }
    @Test
    public void test1() throws Exception{
        Student student = new Student();
        Class<Student> studentClass = Student.class;
        Field[] declaredFields = studentClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getModifiers());
            System.out.println(declaredField.getGenericType());

            Class<?> type = declaredField.getType();
            System.out.println(type);
            declaredField.setAccessible(true);
            boolean primitive = type.isPrimitive();
            if (primitive) {
                continue;
            }
            Object o = type.newInstance();
            declaredField.set(student,o);
        }
    }
}
