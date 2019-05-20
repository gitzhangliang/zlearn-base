package com.zl.design_model.factory;

/**
 * @author tzxx
 * @date 2019/4/30.
 */
public class AServer implements Server {
    @Override
    public void server() {
        System.out.println("Aserver提供服务");
    }
}
