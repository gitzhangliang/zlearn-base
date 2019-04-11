package com.zl.clone;

/**
 * @author tzxx
 * 1.浅克隆：只复制基本类型的数据，引用类型的数据只复制了引用的地址，引用的对象并没有复制，在新的对象中修改引用类型的数据会影响原对象中的引用。
 * 2.深克隆：是在引用类型的类中也实现了clone，是clone的嵌套，复制后的对象与原对象之间完全不会影响。
 * 3.使用序列化也能完成深复制的功能：对象序列化后写入流中，此时也就不存在引用什么的概念了，再从流中读取，生成新的对象，新对象和原对象之间也是完全互不影响的。
 * 4.使用clone实现的深克隆其实是浅克隆中嵌套了浅克隆，与toString方法类似
 */
public class Test {

	public static void main(String[] args) throws CloneNotSupportedException {
		Person p1 = new Person("1",1);
		Student stu = new Student();
		stu.setName("11");
		p1.setStu(stu);

		Person p2 = (Person)p1.clone();
		System.out.println(p1==p2);
		System.out.println(p2.getName());
		System.out.println(p2.getAge());
		System.out.println(p2.getStu().getName());
		System.out.println(p2.getStu()==p1.getStu());
		System.out.println(p2.getName()==p1.getName());
		System.out.println("-------------------");

		p1.setAge(2);
		p1.setName("22");
		p1.getStu().setName("3");
		System.out.println(p2.getName());
		System.out.println(p2.getAge());
		System.out.println(p2.getStu().getName());
		System.out.println(p2.getName()==p1.getName());
	}
}
