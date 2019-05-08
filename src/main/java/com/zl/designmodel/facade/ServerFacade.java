package com.zl.designmodel.facade;

/**外观（门面）模式

 您想为复杂的子系统提供简单的接口。子系统随着它们的发展变得越来越复杂。大多数模式在应用时会导致更多更小的类。这使得子系统更易于重复使用并且更易于自定义，但对于不需要自定义它的客户端也变得更难使用。外观可以提供子系统的简单默认视图，对大多数客户端来说足够好。只有需要更多可定制性的客户才需要超越外观。
 客户端和抽象的实现类之间存在许多依赖关系。引入外观以将子系统与客户端和其他子系统分离，从而提升子系统的独立性和可移植性。
 你想分层你的子系统。使用外观来定义每个子系统级别的入口点。如果子系统是依赖的，那么您可以通过使它们仅通过它们的外观相互通信来简化它们之间的依赖关系。
 * @author tzxx
 * @date 2019/5/5.
 */
public class ServerFacade {
    Server1 server1;
    Server2 server2;
    public ServerFacade(){
        server1 = new Server1();
        server2 = new Server2();
    }
    public void server1(){
        server1.server();
    }

    public void server2(){
        server2.server();
    }
}
class Server1{
    public void server(){
        System.out.println("server1服务");
    }
}

class Server2{
    public void server(){
        System.out.println("server2服务");
    }
}

class Client{
    public static void main(String[] args) {
        ServerFacade facade = new ServerFacade();
        facade.server1();
        facade.server2();
    }
}


