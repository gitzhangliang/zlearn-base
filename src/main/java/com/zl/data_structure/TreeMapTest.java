package com.zl.data_structure;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author tzxx
 * @date 2019/4/4.
 */
public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<Integer,Integer> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2){
                    return -1;
                }else if(o1<o2){
                    return 1;
                }
                return 0;
            }
        });
        map.put(2,2);
        map.put(1,1);
        map.put(4,4);
        map.put(3,3);
        map.forEach((k,v)-> System.out.println(k+"--"+v));
    }

}
