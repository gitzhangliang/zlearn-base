package com.zl.genericity.chain;

/**
 * @author zhangliang
 * @date 2019/7/3.
 */
public class Parent {

    public Parent a(){
        System.out.println("Parent-a");
        return this;
    }
    public Parent b(){
        System.out.println("Parent-b");
        return this;
    }
}

class Sub extends Parent{
    public Sub c(){
        System.out.println("Sub-c");
        return this;
    }
    public static void main(String[] args) {
        new Sub().a().b();
    }
}

class Parent1<B extends Parent1> {

    public B a(){
        System.out.println("Parent1-a");
        return (B)this;
    }
    public B b(){
        System.out.println("Parent1-b");
        return (B)this;
    }
}
class Sub1 extends Parent1<Sub1>{
    public Sub1 c(){
        System.out.println("Sub1-c");
        return this;
    }
    public static void main(String[] args) {
        new Sub1().a().b().c();
    }
}

