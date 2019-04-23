package androidModel.actiontype;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionSubject implements Subject{
    private List<Observer> weChatList = new ArrayList<>();
    @Override
    public void attach(Observer observer) {
        weChatList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        weChatList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for(Observer observer:weChatList){
            observer.update(message);
        }
    }
}
