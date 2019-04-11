package com.zl.innerclass;

import lombok.Getter;
import lombok.Setter;

/**
 * @author tzxx
 * @date 2019/4/10.
 */
public class StaticInnerClass {
    @Getter@Setter
    private static class StaticInner{
        private String name;
        private static String number;
    }

    public static void main(String[] args) {
        StaticInner staticInner = new StaticInner();
        staticInner.setName("11");
        System.out.println(staticInner.name);
    }
}
