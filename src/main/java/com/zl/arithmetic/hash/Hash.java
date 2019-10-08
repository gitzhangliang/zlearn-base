package com.zl.arithmetic.hash;

/**
 * @author zhangliang
 * @date 2019/8/9.
 */
public class Hash {
    private static class Hashadd {
        static int additiveHash(String key, int prime) {
            int hash, i;
            for (hash = key.length(), i = 0; i < key.length(); i++){
                hash += key.charAt(i);
            }
            return (hash % prime);

        }
    }


    public static void main(String[] args) {
        System.out.println(true&false);
        System.out.println(Hashadd.additiveHash("哈希表", 5));
    }
}
