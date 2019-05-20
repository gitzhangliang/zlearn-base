package com.zl.design_model.interpretermodel;

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
        AbstractLogicExpression ex;
        AbstractLogicExpression middleResult = null;
        try {
            for (Expression expression : expressions){
                ex = this.getInLogic().newInstance();
                if (count == 0){
                    TerminalExpression virtual = null;
                   if(this.getInLogic().equals(Logic.AND)){
                       //A && B && C && （虚拟的必为真，不然会造成错误）
                       virtual = new TerminalExpression("", TerminalExpression.Compare.CONTAINS);
                   }else if(this.getInLogic().equals(Logic.OR)){
                       //A || B || C && （虚拟的必为假，如果虚拟为真，则最会结果依赖真正的表达式，造成错误）
                       virtual = new TerminalExpression("", TerminalExpression.Compare.EQUALS);
                   }
                   ex.setExpression1(virtual);
                   ex.setExpression2(expression);
                   count++;
               }else {
                   ex.setExpression1(middleResult);
                   ex.setExpression2(expression);
               }
                middleResult = ex;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(middleResult != null){
            return middleResult.interpret(str);
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
