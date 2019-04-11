package com.zl.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class User{
	private String name;
	
	private int count;
	
	private static List<User> u = null;
	static {
		u = new ArrayList<>();
		u.add(new User("1",1));
		u.add(new User("23",23));
		u.add(new User("333",3));
		u.add(new User("3",45));
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
public User() {
	// TODO Auto-generated constructor stub
}

	public User(String name, int count) {
	this.name = name;
	this.count = count;
}

	public static void main(String[] a) {
						u
						.stream()
						.filter(v->v.count>20);
		Integer ageSum = u
				.stream()
				.reduce(0, (sum, p) -> sum += p.count, (sum1, sum2) -> sum1 +
						sum2);
		System.out.println(ageSum);
		System.out.println(u.stream().mapToInt(User::getCount).sum());



	}
}