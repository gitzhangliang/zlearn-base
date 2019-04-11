package com.zl.innerclass.anonymity;

/**
 * @author tzxx
 */
public class Test {
    private String name;

    {
        name = "sss";
        System.out.println("ddd" + name);

    }

    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.name);
        t.name = "d";
        System.out.println(t.name);

    }
}
