package com.zl.innerclass;

/**局部内部类 定义在方法内
 * @author tzxx
 */
public class Parcel4 {
    public String destination(String s) { 
        class PDestination { 
            private String label; 
 
            private PDestination(String whereTo) { 
                label = whereTo; 
            } 
 
            public String readLabel() { 
                return label; 
            } 
        } 
        return new PDestination(s).readLabel(); 
    } 
 
    public static void main(String[] args) { 
        Parcel4 p = new Parcel4(); 
        System.out.println(p.destination("s"));
    } 
} 