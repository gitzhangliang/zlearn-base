package com.zl.jdk;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tzxx
 * @date 2019/4/11.
 */
public class FinalTest {
    private final List<String> list;

    public FinalTest(List<String> list) {
        this.list = list;
    }

    public static void main(String[] args) {
        FinalTest test = new FinalTest(new ArrayList<>());
        test.list.add("1");
        test.list.forEach(System.out::println);
    }
}
