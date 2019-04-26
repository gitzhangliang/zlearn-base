package com.zl.genericity.generictransfer;

/**
 * @author tzxx
 * @date 2019/4/24.
 */
public interface Server<T, O>{
    O run(T e);
}
