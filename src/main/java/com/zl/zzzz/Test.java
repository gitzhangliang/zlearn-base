package com.zl.zzzz;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author tzxx
 * @date 2019/4/3.
 */
public class Test {
    public String name;

    public Test(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        String s="792_1ã\u0080\u0081æ\u0096°ç«\u009Eäº\u0089æ\u0097¶ä»£ç\u009A\u0084æ\u0088¿ä¼\u0081æ\u0088\u0090æ\u009C¬ç®¡ç\u0090\u0086å\u0088\u009Bæ\u0096°-è§\u0086è§\u0092è½¬å\u008F\u0098ï¼\u0088é»\u0084è¾\u0089å\u008D\u008Eï¼\u0089.mp4";
        try {
            s = new String(s.getBytes(),"GBK");
            System.out.println(s);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
