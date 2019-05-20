package com.zl.design_model.command;

import java.util.ArrayList;
import java.util.List;

/**命令模式：将请求封装为对象，从而允许您使用不同的请求，队列或日志请求参数化客户端，并支持可撤销操作
 * @author tzxx
 * @date 2019/4/29.
 */
public abstract class AbstractCommand {
    protected Receiver receiver;
    public AbstractCommand(Receiver receiver){
        this.receiver = receiver;
    }
    public abstract void execute();
}

class RunCommand extends AbstractCommand{
    public RunCommand(Receiver receiver){
        super(receiver);
    }
    @Override
    public void execute() {
        receiver.run();
    }
}
class WalkCommand extends AbstractCommand{
    public WalkCommand(Receiver receiver){
        super(receiver);
    }
    @Override
    public void execute() {
        receiver.walk();
    }
}

class Receiver{
    void run(){
        System.out.println("run...");
    }
    void walk(){
        System.out.println("walk...");
    }
}

class Invoker{
    List<AbstractCommand> commands = new ArrayList<>();
    void add(AbstractCommand command){
        commands.add(command);
    }

    void notifyExecute(){
        for (AbstractCommand command : commands) {
            command.execute();
        }
        commands.clear();
    }
}

class Client{
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        RunCommand runCommand = new RunCommand(receiver);
        WalkCommand walkCommand = new WalkCommand(receiver);

        Invoker invoker = new Invoker();
        invoker.add(runCommand);
        invoker.add(walkCommand);
        invoker.notifyExecute();
    }
}