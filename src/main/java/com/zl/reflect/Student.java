package com.zl.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author tzxx
 */
public class Student {
    private String name;
    public int age;
    private int sex;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Student(){}

    public String getName() {
        return name;
    }
} 

