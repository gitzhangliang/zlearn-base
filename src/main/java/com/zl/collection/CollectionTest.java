package com.zl.collection;

import java.util.Arrays;
import java.util.List;

/**
 * @author tzxx
 */
public class CollectionTest {
	/**
	 * Arrays.asList 后不能操作此集合（源码）
	 */
	public static void main(String[] args) {
		String[] arr = {"1","2"};
		List<String> ls = Arrays.asList(arr);
		ls.add("1");
	}
}
