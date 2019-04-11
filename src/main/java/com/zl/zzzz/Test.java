package com.zl.zzzz;

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
        List<Test> tests = new ArrayList<>();
        tests.add(new Test("1"));
        tests.add(new Test("2"));
        List<Test> copy = new ArrayList<>();
        copy.addAll(tests);
        Map<String, Test> collect = copy.stream().collect(Collectors.toMap(v -> v.name, Function.identity()));
        collect.forEach((k,v)->{
            System.out.println(k+" "+v.name);
        });
        tests.get(0).name="3";
        collect.forEach((k,v)->{
            System.out.println(k+" "+v.name);
        });
        tests.remove(0);

    }
}
