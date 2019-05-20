package com.zl.design_model.composite;


import java.util.ArrayList;
import java.util.List;

/**组合模式：
 * 1、您想表示对象的部分-整体层次结构（树形结构）。
 * 2、您希望用户忽略组合对象与单个对象的不同，用户将统一地使用组合结构中的所有对象
 *
 * 1、组合模式，就是在一个对象中包含其他对象，这些被包含的对象可能是终点对象（不再包含别的对象），也有可能是非终点对象（其内部还包含其他对象，或叫组对象），我们将对象称为节点，即一个根节点包含许多子节点，这些子节点有的不再包含子节点，而有的仍然包含子节点，以此类推。
 *
 * 2、所谓组合模式，其实说的是对象包含对象的问题，通过组合的方式（在对象内部引用对象）来进行布局，我认为这种组合是区别于继承的，而另一层含义是指树形结构子节点的抽象（将叶子节点与数枝节点抽象为子节点），区别于普通的分别定义叶子节点与数枝节点的方式。
 * @author tzxx
 * @date 2019/4/30.
 */
public abstract class Component {
    protected String name;
    public Component(String name){
        this.name = name;
    }

    public abstract void add(Component component);
    public abstract void remove(Component component);
    public abstract void display(int depth);

    protected String repeat(int time,String s){
        for (int i = 0;i<time;i++){
            s+=s;
        }
        return s;
    }
}

class Composite extends Component{
    List<Component> components = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public void display(int depth) {
        System.out.println(repeat(depth,"-")+name);
        for (Component component : components) {
            component.display(depth+2);
        }
    }
}

class Leaf extends Component{

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
    }

    @Override
    public void remove(Component component) {
    }

    @Override
    public void display(int depth) {
        System.out.println(repeat(depth,"-")+name);
    }
}

class Client{
    public static void main(String[] args) {
        Composite root = new Composite("天职咨询");
        root.add(new Leaf("天职咨询财务部"));
        root.add(new Leaf("天职咨询人力资源部"));

        Composite c1 = new Composite("北京天职信息技术");
        c1.add(new Leaf("北京天职信息技术财务部"));
        c1.add(new Leaf("北京天职信息技术人力资源部"));

        root.add(c1);

        Composite c2 = new Composite("上海青距");
        c2.add(new Leaf("上海青距财务部"));
        c2.add(new Leaf("上海青距人力资源部"));

        root.add(c2);

        root.display(1);

    }
}
