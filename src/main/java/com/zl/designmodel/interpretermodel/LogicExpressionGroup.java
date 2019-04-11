package com.zl.designmodel.interpretermodel;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tzxx
 * @date 2018/9/13
 */
public class LogicExpressionGroup {
    @Getter@Setter
    private List<Expression> expressions = new ArrayList<>();
    @Getter@Setter
    private Logic inLogic;
    @Getter@Setter
    private Logic outLogic;
    @Getter@Setter
    private int index;

    public LogicExpressionGroup() {
    }

    public LogicExpressionGroup(List<Expression> expressions, Logic inLogic,Logic outLogic,int index) {
        this.expressions = expressions;
        this.inLogic = inLogic;
        this.outLogic = outLogic;
        this.index = index;
    }


    public boolean merge(String str){
        int count = 0;
        AbstractLogicExpression expression1 = null;
        AbstractLogicExpression expression2 = null;
        try {
            for (Expression expression : expressions){
               if (count == 0){
                   expression1 = this.getInLogic().newInstance();
                   if(this.getInLogic().equals(Logic.AND)){
                       expression1.setExpression1(new TerminalExpression("", TerminalExpression.Compare.CONTAINS));
                   }else if(this.getInLogic().equals(Logic.OR)){
                       expression1.setExpression1(new TerminalExpression("", TerminalExpression.Compare.EQUALS));
                   }
                   expression1.setExpression2(expression);
                   count++;
               }else {
                   expression2 = this.getInLogic().newInstance();
                   expression2.setExpression1(expression1);
                   expression2.setExpression2(expression);
                   expression1 = expression2;
               }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(expression2 != null){
            return expression2.interpret(str);
        }
        return false;
    }

    enum Logic{
        //and
        AND(AndLogicExpression.class),
        //or
        OR(OrLogicExpression.class);

        @Getter@Setter
        private Class<? extends AbstractLogicExpression> cls;

        Logic(Class<? extends AbstractLogicExpression> cls) {
            this.cls = cls;
        }
        Logic() {
            // TODO Auto-generated constructor stub
        }
        public AbstractLogicExpression newInstance() {
            try {
                return this.cls.newInstance();
            } catch (Exception e) {
                throw new RuntimeException("Unable to instantiate class [" + cls.getName() + "]"+e);
            }
        }
    }

    public static void main(String[] args) {
        LogicExpressionGroup group = new LogicExpressionGroup();
        group.setOutLogic(Logic.AND);
        Logic logic= Logic.AND;
        System.out.println("wqe".contains(""));
    }
}
