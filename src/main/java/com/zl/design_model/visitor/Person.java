package com.zl.design_model.visitor;

/**
 * @author tzxx
 * @date 2019/4/29.
 */
public interface Person {
    void accept(Visitor visitor);
}
