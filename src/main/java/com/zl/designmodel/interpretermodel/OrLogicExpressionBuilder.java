package com.zl.designmodel.interpretermodel;

public class OrLogicExpressionBuilder {
    private Expression expression1;
    private Expression expression2;

    public OrLogicExpressionBuilder setExpression1(Expression expression1) {
        this.expression1 = expression1;
        return this;
    }

    public OrLogicExpressionBuilder setExpression2(Expression expression2) {
        this.expression2 = expression2;
        return this;
    }

    public OrLogicExpression createOrLogicExpression() {
        return new OrLogicExpression(expression1, expression2);
    }
}