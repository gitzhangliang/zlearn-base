package com.zl.design_model.interpretermodel;

import lombok.Getter;
import lombok.Setter;

/**
 * @author tzxx
 * @date 2018/9/13
 */
public abstract class AbstractLogicExpression extends Expression {
    @Getter @Setter
    private Expression expression1 = null;
    @Getter@Setter
    private Expression expression2 = null;

    public AbstractLogicExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

}
