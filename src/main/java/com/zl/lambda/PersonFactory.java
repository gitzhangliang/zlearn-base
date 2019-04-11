package com.zl.lambda;
interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}