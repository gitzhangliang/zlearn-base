package com.zl.zzzz;

public class Happy {
    public static void main(String args[]) {
        int i = 1;
        int j = i++;
        if ((i == (++j)) && ((i++) == j)) {
            i += j;
        }
        System.out.println("i = " + i);
    }
}

class Demo {
    public static void main(String args[]) {
        int num = 50;
        num = num++ * 2;
        System.out.println(num);
    }
}

class Demo1 {
    public static void main(String args[]) {
        long num = 100;
        int x = ( int ) num + 2;
        System.out.println(x);
    }
}

class Demo2 {
    public static void main(String args[]) {
        String str = "";
        for (int x = 0; x < 5; x++) {
            str += x;
        }
        System.out.println(str);
    }
}

class Demo4 {
    public static void main(String args[]) {
        int sum = 0;
        for (int x = 0; x < 10; x++) {
            sum += x;
            if (x % 3 == 0) {
                break;
            }
        }
        System.out.println(sum);
    }
}

class Demo5 {
    public static void main(String args[]) {
        boolean flag = 10 % 2 == 1 && 10 / 3 == 0 && 1 / 0 == 0;
        System.out.println(flag ? "mldn" : "yootk");
    }
}

class Demo6 {
    public static void main(String args[]) {
        int num = 2147483647;
        num += 2L;
        System.out.println(num);
    }
}

class Demo7 {
    public static void main(String args[]) {
        int c = 65;
        int num = 10;
        switch (c) {
            case 'B':
                num++;
            case 65:
                num++;
            case 121:
                num++;
            case 122:
                num++;
            default:
                num--;
        }
        System.out.println(num);
    }
}
