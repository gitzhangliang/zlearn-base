package com.zl.designmodel.interpretermodel;

import java.util.ArrayList;
import java.util.List;

/**解释器模式
 * @author tzxx
 * @date 2018/9/13
 */
public class LogicExpressionTest {
    public static void main(String[] args) {
        List<LogicExpressionGroup> groups = new ArrayList<>();
        LogicExpressionGroup group1 = new LogicExpressionGroup();
        Expression terminal1 = new TerminalExpression("A", TerminalExpression.Compare.CONTAINS);
        Expression terminal2 = new TerminalExpression("B",TerminalExpression.Compare.EQUALS);
        group1.setIndex(1);
        group1.setInLogic(LogicExpressionGroup.Logic.AND);
        group1.setOutLogic(LogicExpressionGroup.Logic.AND);
        group1.getExpressions().add(terminal1);
        group1.getExpressions().add(terminal2);
        groups.add(group1);
        LogicExpressionGroup group2 = new LogicExpressionGroup();
        Expression terminal3 = new TerminalExpression("C",TerminalExpression.Compare.CONTAINS);
        Expression terminal4 = new TerminalExpression("D",TerminalExpression.Compare.EQUALS);
        group2.setIndex(2);
        group2.setInLogic(LogicExpressionGroup.Logic.OR);
        group2.setOutLogic(LogicExpressionGroup.Logic.OR);
        group2.getExpressions().add(terminal3);
        group2.getExpressions().add(terminal4);
        groups.add(group2);
        LogicExpressionGroup group3 = new LogicExpressionGroup();
        Expression terminal5 = new TerminalExpression("E",TerminalExpression.Compare.EQUALS);
        Expression terminal6 = new TerminalExpression("F",TerminalExpression.Compare.EQUALS);
        group3.setIndex(3);
        group3.setInLogic(LogicExpressionGroup.Logic.OR);
        group3.setOutLogic(LogicExpressionGroup.Logic.OR);
        group3.getExpressions().add(terminal5);
        group3.getExpressions().add(terminal6);
        groups.add(group3);
        String str = "AC";
        boolean f = true;
        for (LogicExpressionGroup group : groups){
            if(group.getOutLogic().equals(LogicExpressionGroup.Logic.AND)){
                f = f && group.merge(str);
                System.out.println(group.merge(str));
            }else if(group.getOutLogic().equals(LogicExpressionGroup.Logic.OR)){
                f = f || group.merge(str);
                System.out.println(group.merge(str));
            }
        }
        System.out.println("匹配结果"+f);
    }
}
