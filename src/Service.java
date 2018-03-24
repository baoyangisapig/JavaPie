import com.sun.security.ntlm.Server;

import java.io.*;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Service {
    private Map remoteObjects=new HashMap();
    public void register(String className,Object remoteobject){
        remoteObjects.put(className,remoteobject);
    }

   public RemoteCall invoke(RemoteCall call)
   {
        Object Result =null;
        try
        {
            String className=call.getClassName();
            String MethodName=call.getMethodName();
            Class[] paramType=call.getParamType();
            Object[] param=call.getParam();
            Class ClassType=Class.forName(className);
            Method mmethod=ClassType.getMethod(MethodName,paramType);
            Object remoteObject=remoteObjects.get(className);

            if(remoteObject==null)
            {
                    System.out.println("错误");
            }
            else
            {
                Result=mmethod.invoke(remoteObject,param);
                System.out.println("w");
            }
        }
        catch (Exception e)
        {
            Result=e;

        }
        call.setResult(Result);
        return call;
   }

   public void  service() throws IOException, ClassNotFoundException {
       ServerSocket serverSocket=new ServerSocket(8080);
       System.out.println("服务器启动");
       while(true)
       {

           Socket socket =serverSocket.accept();

           InputStream is=socket.getInputStream();
           ObjectInputStream ois=new ObjectInputStream(is);


           OutputStream os=socket.getOutputStream();
           ObjectOutputStream oos=new ObjectOutputStream(os);

           RemoteCall remoteCall= (RemoteCall) ois.readObject();//读取对象
            System.out.println(remoteCall);
            remoteCall=invoke(remoteCall);
            oos.writeObject(remoteCall);//写对象
            ois.close();
            oos.close();
            socket.close();
       }
   }


}
