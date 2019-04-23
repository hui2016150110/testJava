package androidModel.actiontype;

public class Client {
    public static void main(String[] args){
        SubscriptionSubject subscriptionSubject = new SubscriptionSubject();
        WeChatUser user1 = new WeChatUser("user1");
        WeChatUser user2 = new WeChatUser("user2");
        WeChatUser user3 = new WeChatUser("user3");

        subscriptionSubject.attach(user1);
        subscriptionSubject.attach(user2);
        subscriptionSubject.attach(user3);

        subscriptionSubject.notify("主题更新了");

    }
}
