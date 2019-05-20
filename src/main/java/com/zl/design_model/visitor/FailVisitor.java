package com.zl.design_model.visitor;

/**
 * @author tzxx
 * @date 2019/4/29.
 */
public class FailVisitor implements Visitor {
    @Override
    public void visitorMan(Man man) {
        System.out.println("man fail");

    }

    @Override
    public void vistorWoman(Woman woman) {
        System.out.println("man fail");

    }
}
