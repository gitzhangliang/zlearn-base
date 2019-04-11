package com.zl.jdk;

/**重载
 * 1.精确匹配
 * 2.如果是基本数据类型，自动转换为更大范围表示的基本数据类型
 * 3.自动装箱拆箱
 * 4.子类向上转型继承父类依次匹配
 * 5.可变参数匹配
 * @author tzxx
 * @date 2019/3/4.
 */
public class Overload {
    public void print(int a){
        System.out.println("int--"+a);
    }
    public void print(Object a){
        System.out.println("Object--"+a);
    }
    public void print(long a){
        System.out.println("long--"+a);
    }

    public static void main(String[] args) {
        new Overload().print(new Integer(1));
        new Overload().print(2);
    }
}
