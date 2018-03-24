import java.io.Serializable;

public class RemoteCall implements Serializable{
    private String className;
    private String methodName;
    private Class[] paramType;
    private Object[] param;
    public  Object result;

    public RemoteCall(){}
    public RemoteCall(String className,String methodName,Class[] paramType,Object[] param)
    {
        this.className=className;
        this.methodName=methodName;
        this.paramType=paramType;
        this.param=param;
    }
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParamType() {
        return paramType;
    }

    public void setParamType(Class[] paramType) {
        this.paramType = paramType;
    }

    public Object[] getParam() {
        return param;
    }

    public void setParam(Object[] param) {
        this.param = param;
    }

    public Object getResult() {
        return result;
    }

    public  void setResult(Object result) {
        this.result=result;
    }
}
