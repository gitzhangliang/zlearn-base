package com.zl.genericity.generictransfer;

import com.zl.genericity.Animal;
import com.zl.genericity.Cat;

/**
 * @author tzxx
 * @date 2019/4/24.
 */


public abstract class AbstractServer2<C extends Cat,D> implements Server<C,D> {
    @Override
    public D run(C e) {
        return null;
    }
}
