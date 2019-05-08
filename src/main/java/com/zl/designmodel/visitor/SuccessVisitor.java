package com.zl.designmodel.visitor;

/**
 * @author tzxx
 * @date 2019/4/29.
 */
public class SuccessVisitor implements Visitor {
    @Override
    public void visitorMan(Man man) {
        System.out.println("man success");
    }

    @Override
    public void vistorWoman(Woman woman) {
        System.out.println("woman success");
    }
}
