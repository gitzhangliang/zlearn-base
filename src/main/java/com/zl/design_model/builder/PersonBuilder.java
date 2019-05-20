package com.zl.design_model.builder;

import lombok.Getter;
import lombok.Setter;

/**建设者模式：将复杂对象的构造与其表示分开，以便相同的构造过程可以创建不同的表示。
 * @author tzxx
 * @date 2019/5/5.
 */
public abstract class PersonBuilder {
    Person person;
    public PersonBuilder(){
        person = new Person();
    }
    abstract void buildHead();
    abstract void buildBody();
    abstract void buildFoot();
    abstract void buildSex();

    public Person buildPerson(){
        return person;
    }
}
@Getter@Setter
class Person{
    private String sex;
    private String head;
    private String body;
    private String foot;
}
class ManBuilder extends PersonBuilder{
    @Override
    void buildHead() {
        person.setHead("短发");
    }

    @Override
    void buildSex() {
        person.setSex("男");
    }

    @Override
    void buildBody() {
        person.setBody("啤酒肚");
    }

    @Override
    void buildFoot() {
        person.setFoot("脚尺寸45");
    }
}
class WomanBuilder extends PersonBuilder{
    @Override
    void buildHead() {
        person.setHead("长发");
    }

    @Override
    void buildSex() {
        person.setSex("女");
    }

    @Override
    void buildBody() {
        person.setBody("瘦");
    }

    @Override
    void buildFoot() {
        person.setFoot("脚尺寸35");
    }
}

class PersonDirector {
    public Person constructPerson(PersonBuilder pb) {
        pb.buildSex();
        pb.buildHead();
        pb.buildBody();
        pb.buildFoot();
        return pb.buildPerson();
    }
}

class Client{
    public static void main(String[] args) {
        PersonDirector director = new PersonDirector();
        Person man = director.constructPerson(new ManBuilder());
        Person woman = director.constructPerson(new WomanBuilder());
        System.out.println(man.getSex()+"--"+man.getHead()+"--"+man.getBody()+"--"+man.getFoot());
        System.out.println(woman.getSex()+"--"+woman.getHead()+"--"+woman.getBody()+"--"+woman.getFoot());
    }
}

