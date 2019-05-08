package com.zl.designmodel.interpretermodel;

/**
 *
 * @author tzxx
 * @date 2018/9/13
 */
public class OrLogicExpression extends AbstractLogicExpression{

    public OrLogicExpression(Expression e1, Expression e2) {
        super(e1,e2);
    }

    @Override
    public boolean interpret(String str) {
        return getExpression1().interpret(str) && getExpression2().interpret(str);
    }

}
