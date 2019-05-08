package com.zl.designmodel.factory.simplefactory;

import com.zl.designmodel.factory.AServer;
import com.zl.designmodel.factory.BServer;
import com.zl.designmodel.factory.Server;

/**
 * @author tzxx
 * @date 2019/4/30.
 */
public class SimpleFactory {
    public static Server getServer(String type){
        switch (type){
            case "A":
                return new AServer();

            case "B":
                return new BServer();

            default:return null;
        }
    }

    public static void main(String[] args) {
        Server server1 = SimpleFactory.getServer("A");
        server1.server();
        //如果将两个B改为A 需要修改两处
        Server server2 = SimpleFactory.getServer("B");
        server2.server();
        Server server3 = SimpleFactory.getServer("B");
        server3.server();

    }
}
