package com.zl.arithmetic;

import java.util.LinkedHashMap;
import java.util.Map;

/**LinkedHashMap实现LRU
 * @author tzxx
 */
public class SimpleCache<K, V> extends LinkedHashMap<K, V> {

    private static final int MAX_NODE_NUM = 100;

    private int limit;

    public SimpleCache() {
        this(MAX_NODE_NUM);
    }

    public SimpleCache(int limit) {
        super(limit, 0.75f, true);
        this.limit = limit;
    }

    /**
     * 判断节点数是否超限
     * @param eldest
     * @return 超限返回 true，否则返回 false
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > limit;
    }

    public static void main(String[] args) {
        SimpleCache<Integer, Integer> cache = new SimpleCache<>(3);

        for (int i = 0; i < 10; i++) {
            cache.put(i, i * i);
        }

        System.out.println("插入10个键值对后，缓存内容：");
        System.out.println(cache + "\n");

        System.out.println("访问键值为7的节点后，缓存内容：");
        cache.get(7);
        System.out.println(cache + "\n");

        System.out.println("插入键值为1的键值对后，缓存内容：");
        cache.put(1, 1);
        System.out.println(cache);
    }
    public static void main1(String[] args) {
        LinkedHashMap<String, Object> hasMap = new LinkedHashMap<String, Object>();
        hasMap.put("name", "zhangsan");
        hasMap.put("age", 20);
        hasMap.put("addr", "北京市");
        hasMap.put(null, null);
        hasMap.put("info", null);

        for (Map.Entry<String, Object> entry : hasMap.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        hasMap.get("age");
        System.out.println("--");
        for (Map.Entry<String, Object> entry : hasMap.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
