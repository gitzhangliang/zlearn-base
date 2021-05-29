package com.zl.innerclass;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class Outer {
    public static void main(String[] args) {
        Outer outer = new Outer(); 
        Inner inner = outer.new Inner();
        inner.print("Outer.new");

        inner = outer.getInner(); 
        inner.print("Outer.get");
    }

    /**
     * 个人推荐使用getxxx()来获取成员内部类，尤其是该内部类的构造函数无参数时
     */

    public Inner getInner() { 
        return new Inner(); 
    }

    public static void stame() {
        log.info("stame");
    }
    public void notStame() {
        log.info("notStame");
    }

    public class Inner {
        public Inner(){

        }

        public void print(String str) {
            log.info(str);
            stame();
            notStame();
            getInner();
        } 
        
    } 
} 