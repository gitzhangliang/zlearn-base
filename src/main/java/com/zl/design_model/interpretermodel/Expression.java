package com.zl.design_model.interpretermodel;

import java.util.StringTokenizer;

public abstract class Expression {
    public abstract boolean interpret(String str);
}
 class TerminalExpression1 extends Expression {

    private String literal = null;

    public TerminalExpression1(String str) {
        literal = str;
    }
     @Override
    public boolean interpret(String str) {
        StringTokenizer st = new StringTokenizer(str);
        while (st.hasMoreTokens()) {
            String test = st.nextToken();
            if (test.equals(literal)) {
                return true;
            }
        }
        return false;
    }

     public static void main(String[] args) {
         Expression terminal1 = new TerminalExpression1("A");
         System.out.println(terminal1.interpret("b c"));
     }
}
 class AndExpression extends Expression {

    private Expression expression1 = null;
    private Expression expression2 = null;

    public AndExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }
     @Override
    public boolean interpret(String str) {
        return expression1.interpret(str) && expression2.interpret(str);
    }
}
 class OrExpression extends Expression {
    private Expression expression1 = null;
    private Expression expression2 = null;

    public OrExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }
    @Override
    public boolean interpret(String str) {
        return expression1.interpret(str) || expression2.interpret(str);
    }
}
 class Client {

    /**
     * 构建解析树
     */
    public static Expression buildInterpreterTree() {
        // Literal
        Expression terminal1 = new TerminalExpression1("A");
        Expression terminal2 = new TerminalExpression1("B");
        Expression terminal3 = new TerminalExpression1("C");
        Expression terminal4 = new TerminalExpression1("D");
        // B C
        Expression alternation1 = new OrExpression(terminal2, terminal3);
        // A Or (B C)
        Expression alternation2 = new OrExpression(terminal1, alternation1);
        // D And (A Or (B C))
        return new AndExpression(terminal4, alternation2);
    }

    public static void main(String[] args) {
        //(aa And bb)or(cc or dd)And(ee And ff)
        Expression define = buildInterpreterTree();
        String context2 = "D A";
        String context1 = "A B";
        System.out.println(define.interpret(context1));
        System.out.println(define.interpret(context2));
        System.out.println(context1.contains("D") && (context1.contains("A") || (context1.contains("B") || context1.contains("C"))));
    }

}
