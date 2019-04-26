package com.zl.genericity.generictransfer;

import com.zl.genericity.Animal;
import com.zl.genericity.Cat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tzxx
 * @date 2019/4/24.
 */
public abstract class AbstractServer1<A extends Animal,B> implements Server<A,B>{
    @Override
    public B run(A e) {
        return null;
    }
}
