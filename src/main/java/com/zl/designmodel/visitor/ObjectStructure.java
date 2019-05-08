package com.zl.designmodel.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tzxx
 * @date 2019/4/29.
 */
public class ObjectStructure {
    private List<Person> people = new ArrayList<>();
    public void add(Person person){
        people.add(person);
    }
    public void remove(Person person){
        people.remove(person);
    }

    public void accept(Visitor visitor){
        for (Person person : people) {
            person.accept(visitor);
        }
    }
}
