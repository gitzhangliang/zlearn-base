package com.zl.designmodel.memento;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**备忘录模式：在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态
 * Memento 包含了要被恢复的对象的状态。Originator 创建并在 Memento 对象中存储状态。Caretaker 对象负责从 Memento 中恢复对象的状态。
 * 缺点：消耗资源。如果类的成员变量过多，势必会占用比较大的资源，而且每一次保存都会消耗一定的内存
 * @author tzxx
 * @date 2019/4/30.
 */
public class Game {
    @Getter@Setter
    private String state;

    public GameMemento createMemento(){
        return new GameMemento(state);
    }

    public void show(){
        System.out.println("游戏进度："+state);
    }

}

class GameMemento{
    @Getter@Setter
    private String state;
    public GameMemento(String state){
        this.state = state;
    }
}


class CareTaker {
    private List<GameMemento> mementoList = new ArrayList<>();

    public void add(GameMemento state){
        mementoList.add(state);
    }

    public GameMemento get(int index){
        return mementoList.get(index);
    }
}

class Client{
    public static void main(String[] args) {
        Game game = new Game();
        game.setState("开始");
        game.show();

        CareTaker careTaker = new CareTaker();
        careTaker.add(game.createMemento());

        game.setState("正在打boss");
        game.show();
        careTaker.add(game.createMemento());

        game.setState("失败");
        game.show();
        careTaker.add(game.createMemento());

        game.setState(careTaker.get(0).getState());
        game.show();
    }
}
