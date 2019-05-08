package com.zl.designmodel.visitor;

/**
 * @author tzxx
 * @date 2019/4/29.
 */
public class Man implements Person {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitorMan(this);
    }
}
