package com.zl.innerclass.anonymity;
/**
 * @author tzxx
 */
public class Outer1 {
    public static void main(String[] args) { 
        Outer1 outer = new Outer1(); 
        Inner inner = outer.getInner("Inner", "gz"); 
        System.out.println(inner.getName()); 
    } 
 
    public Inner getInner(final String name, String city) { 
        return new Inner() { 
            @SuppressWarnings("unused")
			private String nameStr = name; 
 
            @Override
            public String getName() {
                return name; 
            } 
        }; 
    }
    /**
     * 注释后，编译时提示类Inner找不到
     */
    interface Inner {
        String getName(); 
    } 
} 
 
