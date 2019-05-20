package com.zl.design_model.iterator;

import java.util.ArrayList;
import java.util.List;

/**迭代器模式
 * @author tzxx
 * @date 2019/4/30.
 */
public interface IIterator<T> {
    T next();
    boolean hasNext();
}

class MyList<T> implements IIterator<T>{
    List<T> list =new ArrayList<>();
    int index = 0;

    void add(T t){
        list.add(t);
    }

    @Override
    public T next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }
}

class Client{
    public static void main(String[] args) {
        MyList<Integer> list = new MyList();
        list.add(1);
        list.add(2);
        while (list.hasNext()){
            System.out.println(list.next());
        }
    }
}
