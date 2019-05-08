package com.zl.designmodel.visitor;

/**
 * @author tzxx
 * @date 2019/4/29.
 */
public interface Person {
    void accept(Visitor visitor);
}
