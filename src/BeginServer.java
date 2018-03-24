import com.sun.security.ntlm.Server;

public class BeginServer {
    public static void main(String[] args) throws Exception{
        Service server=new Service();
        server.register("RPCServiceImpl",new RPCServiceImpl());
        server.service();
    }
}
