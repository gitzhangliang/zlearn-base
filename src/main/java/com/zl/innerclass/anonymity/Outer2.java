package com.zl.innerclass.anonymity;
public class Outer2 { 
    public static void main(String[] args) { 
        Outer2 outer = new Outer2(); 
        Inner inner = outer.getInner("Inner", "gz"); 
        System.out.println(inner.getName()); 
    } 
 
    public Inner getInner(final String name, String city) { 
        return new Inner(name, city) { 
            private String nameStr = name; 
 
            @Override
            public String getName() {
                return nameStr; 
            } 
        }; 
    } 
} 
 
abstract class Inner { 
    Inner(String name, String city) { 
        System.out.println(city); 
    } 
 
    abstract String getName(); 
} 