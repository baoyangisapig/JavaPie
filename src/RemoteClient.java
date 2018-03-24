import java.io.*;
import java.net.Socket;

public class RemoteClient {
    public  void invoke() throws Exception
    {
      Socket socket = new Socket("localhost",8080);
      OutputStream os=socket.getOutputStream();
      ObjectOutputStream oos=new ObjectOutputStream(os);//输出
      InputStream is=socket.getInputStream();
      ObjectInputStream ois=new ObjectInputStream(is);


        Class<?>  remotecallclass =RemoteCall.class;
        RemoteCall remotecall= new RemoteCall("RPCServiceImpl","getinformation",new Class[]{String.class},new Object[]{"rpc success"});

        oos.writeObject(remotecall);
        remotecall= (RemoteCall) ois.readObject();
        System.out.println(remotecall.getResult());
        oos.close();
        ois.close();
        new Socket().close();
    }

    public static void main(String[] args) throws Exception {
        new RemoteClient().invoke();
    }

}
