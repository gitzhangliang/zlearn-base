package com.zl.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class Test {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		Collections.sort(names, (a, b) -> b.compareTo(a));
//		Collections.sort(names, new Comparator<String>() {
//		    @Override
//		    public int compare(String a, String b) {
//		    	System.out.println(a);
//		    	System.out.println(b);
//		        return a.compareTo(b);
//		    }
//		});
		for (String string : names) {
			System.out.println(string);

		}
		System.out.println();
	}
	

	public void function(){
		Service t = new Service();
		search(2,(q)->t.list(q),(q)->t.count(q));
		
	}


	public void search(int q,Function<Integer, List<String>> list, Function<Integer, Integer> count) {
		List<String> strlist = list.apply(q);
		int sum = count.apply(q);
		
	}


}
class Service{
	public List<String> list(int q){
		return new ArrayList<String>(q);
	}
	public int count(int q){
		return 0;
	}
}
