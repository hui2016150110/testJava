package androidModel.callbackDemo;

public class CallbackTest implements MyCallBack{
    public static void main(String[] args){
        CallbackTest test = new CallbackTest();
        test.test();
    }
    public void test(){
        CallbackUtils callbackUtils = new CallbackUtils(this);
        callbackUtils.callback("回调成功");
    }

    @Override
    public void doSomething(String s) {
        System.out.println(s);
    }
}
