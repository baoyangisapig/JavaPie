import RpcInterface.RPCService;

public class RPCServiceImpl implements RPCService {

    @Override
    public String getinformation(String s) {
        return ("WE GET INFORMATION:"+s);
    }
}
