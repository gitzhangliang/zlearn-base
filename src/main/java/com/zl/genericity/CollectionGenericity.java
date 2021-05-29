package com.zl.genericity;

import java.util.ArrayList;
import java.util.List;

/**集合泛型
 * @author tzxx
 * @date 2019/2/26.
 */
public class CollectionGenericity {
    public static void main(String[] args) {

        CollectionGenericity collectionGenericity = new CollectionGenericity();

        List<Animal> animals = new ArrayList<>();

        List<Cat> cats = new ArrayList<>();
        cats.add(new GfeiCat());
        collectionGenericity.add(cats );

        List<GfeiCat> gfeiCats = new ArrayList<>();
        List<YeCat> yeCats = new ArrayList<>();

        List<? extends Animal> exAnimals =  new ArrayList();
        //? extends Cat 可能指向GfeiCat或Cat或YeCat
        // 当想添加cat时,若指向gfeiCats或YeCat 则不能添加
        // 当想添加gfeiCats时,若指向YeCat 则不能添加
        // 当想添加YeCat时,若指向gfeiCats 则不能添加
        // 所以? extends Cat 只能添加null
        //? extends T 消费集合
        List<? extends Cat> exCats = cats;
        List<? extends Cat> exCats1 = gfeiCats;

        //? super Cat 可能指向Animal或Cat
        // 当指向Cat时     不能添加Animal,所以? super Cat 只能添加Cat及其子类
        // 当指向Animal时  可以添加Animal其子类
        // 综上，可以添加Cat及其子类
        //? super T 生产集合
        List<? super Cat> suCats = animals;
        List<? super Cat> suCats1 = cats;

        suCats.add(new GfeiCat());
        suCats.add(new Cat());


    }

    public <T extends  Animal> void add(List<T> animals ){
        //animals.add(new Animal());//错误
        animals.add(null);
    }
    public  void arrayCopy(List<? extends Animal> animals,List<? super Animal> a){
        for (Animal animal : animals) {
            a.add(animal);
        }
        for (Object o : a) {
            
        }

    }

}
