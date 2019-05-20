package com.zl.design_model.visitor;

/**访问者模式：表示一个作用于某对象结构中的各元素的操作。它是你可以在不改变各元素的类的前提下定义作用于这些元素的操作
 * 名词解释：对象结构->ObjectStructure
 *          对象结构中的【各元素】->man 和 woman
 *          对象结构中的各元素的【操作】-> successVisitor failVisitor
 * 主要将数据结构和作用于结构上的操作之间的耦合解脱开，使得操作集合可以相对自由的演化
 * 优点：增加新的操作很容易，只要增加一个新的访问者（实现visitor接口就行），将有关的行为集中到一个访问者对象中
 * 缺点：增加新的数据结构变得困难，vistor接口需要具体的实现类，不符合依赖倒置原则（没依赖抽象）
 *
 * 数据结构即本例中的ObjectStructure中只包含man和woman,如果再增加一种结构，则需要添加该结构在succss和fail下的行为，
 * 那么就必须修改vistor接口，相应的实现类也需要修改，不符合开闭原则，所以只适用于【数据结构相对稳定的系统】
 * @author tzxx
 * @date 2019/4/29.
 */
public interface Visitor {
    void visitorMan(Man man);
    void vistorWoman(Woman woman);
}
