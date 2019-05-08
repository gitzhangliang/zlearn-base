package com.zl.designmodel.factory.factorymethod;

import com.zl.designmodel.factory.AServer;
import com.zl.designmodel.factory.BServer;
import com.zl.designmodel.factory.Server;

/**工厂方法克服了简单工厂违背开-闭原则的确定，保留了封装对象创建过程的优点
 * 工厂方法把简单工厂的内部逻辑判断移到了客户端代码来进行
 * @author tzxx
 * @date 2019/4/30.
 */
public interface FactoryMethod {
    Server getServer();
}

class AserverFactory implements FactoryMethod{
    @Override
    public Server getServer() {
        return new AServer();
    }
}

class BserverFactory implements FactoryMethod{
    @Override
    public Server getServer() {
        return new BServer();
    }
}

class Client{
    public static void main(String[] args) {
        FactoryMethod factoryMethod = new AserverFactory();
        factoryMethod.getServer().server();

        //如果将两个B改为A 只需修改一处
        factoryMethod = new BserverFactory();
        factoryMethod.getServer().server();
        factoryMethod.getServer().server();
    }
}
