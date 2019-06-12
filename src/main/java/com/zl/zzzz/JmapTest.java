package com.zl.zzzz;

public class JmapTest {
    public static void main(String[] args) throws InterruptedException {
        JmapTest test = new JmapTest();
        fun(test);
    }

    private JmapTest next;
    public JmapTest() {
    }
    public static void fun(JmapTest m) throws InterruptedException {
        m.next = new JmapTest();
        Thread.sleep(3000);
        fun(m.next);
    }
}