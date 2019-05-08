package com.zl.designmodel.visitor;

/**
 * @author tzxx
 * @date 2019/4/29.
 */
public class Test {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.add(new Man());
        objectStructure.add(new Woman());
        objectStructure.accept(new SuccessVisitor());
        objectStructure.accept(new FailVisitor());
    }
}
