package com.zl.design_model.factory.abstractfactory;

import com.zl.design_model.factory.*;

/**抽象工厂模式：提供了一种封装一组具有共同主题但没有指定其具体类的单个工厂的方法
 *当抽象工厂只一类抽象产品时，则和工厂方法模式一置
 * @author tzxx
 * @date 2019/4/30.
 */
public interface AbstractFactory {
    Server getServer();
    Vip getVip();
}

class FactoryA implements AbstractFactory{
    @Override
    public Server getServer() {
        return new AServer();
    }

    @Override
    public Vip getVip() {
        return new AVip();
    }
}
class FactoryB implements AbstractFactory{
    @Override
    public Server getServer() {
        return new BServer();
    }

    @Override
    public Vip getVip() {
        return new BVip();
    }
}
class FactoryMaker {

    public enum FactoryType {
        A, B
    }

    /**
     * The factory method to create KingdomFactory concrete objects.
     */
    public static AbstractFactory makeFactory(FactoryType type) {
        switch (type) {
            case A:
                return new FactoryA();
            case B:
                return new FactoryB();
            default:
                throw new IllegalArgumentException("FactoryType not supported.");
        }
    }
}
class Client{
    public static void main(String[] args) {
        AbstractFactory factory = FactoryMaker.makeFactory(FactoryMaker.FactoryType.A);
        factory.getServer().server();
        factory.getVip().vip();
    }
}

