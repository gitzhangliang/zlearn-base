package com.zl.arithmetic;

import java.util.HashMap;

/**LRU算法就是当缓存空间满了的时候，将最近最少使用的数据从缓存空间中删除以增加可用的缓存空间来缓存新数据。
 * 这个算分的内部有一个缓存列表，每当一个缓存数据被访问的时候，这个数据就会被提到列表尾部，
 * 每次都这样的话，列表的头部数据就是最近最不常使用的了，当缓存空间不足时，就会删除列表头部的缓存数据。
 * @author tzxx
 * @date 2018/11/5
 */
public class LRUCache {
    private Node head;
    private Node end;
    /**缓存存储上限*/
    private int limit;
    private HashMap<String, Node> hashMap;

    public LRUCache(int limit) {
        this.limit = limit;
        hashMap = new HashMap<>();
    }

    public String get(String key) {
        Node node = hashMap.get(key);
        if (node == null) {
            return null;
        }
        refreshNode(node);
        return node.value;
    }

    public void put(String key, String value) {
        Node node = hashMap.get(key);
        if (node == null) {
            //如果key不存在，插入key-value
            if (hashMap.size() >= limit) {
                String oldKey = removeNode(head);
                hashMap.remove(oldKey);
            }
            node = new Node(key, value);
            addNode(node);
            hashMap.put(key, node);
        } else {
            //如果key存在，刷新key-value
            node.value = value;
            refreshNode(node);
        }
    }

    public void remove(String key) {
        Node node = hashMap.get(key);
        removeNode(node);
        hashMap.remove(key);
    }

    /**
     * 刷新被访问的节点位置
     *
     * @param node 被访问的节点
     */
    private void refreshNode(Node node) {
        //如果访问的是尾节点，无需移动节点
        if (node == end) {
            return;
        }
        //移除节点
        removeNode(node);
        //重新插入节点
        addNode(node);
    }

    /**
     * 删除节点
     *
     * @param node 要删除的节点
     */

    private String removeNode(Node node) {

        if (node == end) {
            //移除尾节点
            end = end.pre;
        } else if (node == head) {
            //移除头节点
            head = head.next;
        } else {
            //移除中间节点
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.key;
    }

    /**
     * 尾部插入节点
     *
     * @param node 要插入的节点
     */
    private void addNode(Node node) {
        if (end != null) {
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end = node;
        if (head == null) {
            head = node;
        }
    }

    class Node {
        Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
        public Node pre;

        public Node next;

        public String key;

        public String value;
    }

    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(5);
        lruCache.put("001", "用户1信息");
        lruCache.put("002", "用户1信息");
        lruCache.put("003", "用户1信息");
        lruCache.put("004", "用户1信息");

        lruCache.put("005", "用户1信息");
        lruCache.get("002");
        lruCache.put("004", "用户2信息更新");
        lruCache.put("006", "用户6信息");

        System.out.println(lruCache.get("001"));

        System.out.println(lruCache.get("006"));
    }
}
