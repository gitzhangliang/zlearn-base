package com.zl.lambda;
@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);

}
