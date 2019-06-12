package com.zl.innerclass;

import lombok.Getter;
import lombok.Setter;

/**
 * @author tzxx
 * @date 2019/4/10.
 */
public class StaticInnerClass {
    {
        System.out.println("构造代码块");
    }
    @Getter@Setter
    static class StaticInner{
        private String name;
        private static String number;
        public static void  staMe(){

        }
    }

    public static void main(String[] args) {
        StaticInnerClass staticInnerClass = new StaticInnerClass();
        StaticInner staticInner = new StaticInner();
        staticInner.setName("11");
        System.out.println(staticInner.name);
    }

    public void callInner(){
        StaticInner.staMe();
    }
}
