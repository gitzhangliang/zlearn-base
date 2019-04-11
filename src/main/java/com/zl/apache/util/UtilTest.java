package com.zl.apache.util;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;

/**
 * apache Utils
 * @author tzxx
 */
public class UtilTest {

	public void str() {
		Integer[] arr = {1,2};
		System.out.println(StringUtils.join(arr,"::"));
	}

	/**
	 * 数组扩容
	 */
	public void arr() {
		Integer[] arr = {1,2};
		arr = ArrayUtils.add(arr, 3);
		for (Integer i : arr){
			System.out.println(i);
		}
	}

	public void eunmTest() {
		Map<String, PayTypeEnum> map = EnumUtils.getEnumMap(PayTypeEnum.class);
		map.forEach((k, v) -> System.out.println(k + "  " + v.getValue()));
		List<PayTypeEnum> list = EnumUtils.getEnumList(PayTypeEnum.class);
		Gson gson = new Gson();
		String t = gson.toJson(list);
		System.out.println(t);
	}
}

enum PayTypeEnum {
	//服务费
	SERVICE("服务费", "1"),
	SURCHARGE("附加费", "2");

	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private String value;

	PayTypeEnum() {
	}

	PayTypeEnum(String name, String value) {
		this.name = name;
		this.value = value;
	}

}
