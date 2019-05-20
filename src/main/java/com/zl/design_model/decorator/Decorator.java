package com.zl.design_model.decorator;

/**装饰者模式：允许向一个现有的对象添加新的功能，同时又不改变其结构
 * 优点：装饰类和被装饰类可以独立发展，不会相互耦合，装饰模式是继承的一个替代模式，装饰模式可以动态扩展一个实现类的功能。
 * 缺点：多层装饰比较复杂。即装饰顺序很重要
 *
 *
 *
 *装饰器模式是为了增强目标对象
 *代理模式是为了保护隐藏目标对象

 * 代理模式（Proxy 模式）可理解为：我想做，但不能做，我需要有一个能干的人来帮我做。

 * 装饰器模式（Decorator 模式）可理解为：我想做，但不能做，我需要有各类特长的人来帮我做，但我有时只需要一个人，有时又需要很多人。

 * 它们的区别就是，Proxy 模式需要的是一个能人，而 Decorator 模式需要的是一个团队。

 * 有些情况下，拥有了一个团队，会更加利于工作分工，而不至于将所有的事情，都让这个能人来干，他终将有一天会 hold 不住的。但有些情况下，人多了反而不好，只需要一个能人就行了。

 * @author tzxx
 * @date 2019/4/30.
 */
public abstract class Decorator implements Animal{
    protected Animal animal;
    public Decorator(Animal animal){
        this.animal = animal;
    }
    @Override
    public abstract void run();
}

class Food extends Decorator{
    public Food(Animal animal) {
        super(animal);
    }

    @Override
    public void run() {
        System.out.println("进食。。。");
       animal.run();
    }
}

class Sleep extends Decorator{
    public Sleep(Animal animal) {
        super(animal);
    }

    @Override
    public void run() {
        System.out.println("睡觉。。。");
        animal.run();
    }
}

interface Animal{
    void run();
}

class Tiger implements Animal{
    @Override
    public void run() {
        System.out.println("奔跑中。。。");
    }
}

class Client{
    public static void main(String[] args) {
        Animal animal = new Tiger();
        Food food = new Food(animal);
        food.run();

        Sleep sleep = new Sleep(food);
        sleep.run();
    }
}
