package androidModel.callbackDemo;

public class CallbackUtils {
    private MyCallBack myCallBack;
    public CallbackUtils(MyCallBack myCallBack){
        this.myCallBack = myCallBack;
    }
    public void callback(String s){
        myCallBack.doSomething(s);
    }
}
