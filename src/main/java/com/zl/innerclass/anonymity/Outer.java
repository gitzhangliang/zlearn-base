package com.zl.innerclass.anonymity;
/**
 * @author tzxx
 */
public class Outer {
    public static void main(String[] args) { 
        Outer outer = new Outer(); 
        Inner inner = outer.getInner("Inner", "gz"); 
        System.out.println(inner.getName()); 
        System.out.println(inner.getProvince()); 
    } 
 
    public Inner getInner(final String name, final String city) { 
        return new Inner() { 
            private String nameStr = name; 
            private String province; 
 
            // 实例初始化 
            { 
                if (city.equals("gz")) { 
                    province = "gd"; 
                }else { 
                    province = ""; 
                } 
            } 
 
            @Override
            public String getName() {
                return nameStr; 
            } 
 
            @Override
            public String getProvince() {
                return province; 
            } 
        }; 
    } 
    interface Inner { 
        String getName(); 
        String getProvince(); 
    } 
} 
 
