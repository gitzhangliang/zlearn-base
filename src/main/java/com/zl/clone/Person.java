package com.zl.clone;

/**
 * @author tzxx
 */
public class Person implements Cloneable {
	private String name;
	private int age;
	private Student stu;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Person newp = (Person) super.clone();
		newp.stu = (Student) stu.clone();
		return newp;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person() {
	}
}
