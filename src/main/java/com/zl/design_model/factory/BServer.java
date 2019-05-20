package com.zl.design_model.factory;

/**
 * @author tzxx
 * @date 2019/4/30.
 */
public class BServer implements Server {
    @Override
    public void server() {
        System.out.println("Bserver提供服务");
    }
}
