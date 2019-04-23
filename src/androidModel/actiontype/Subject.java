package androidModel.actiontype;

public interface Subject {

    /**
     * @param observer
     *增加一个观察者
     */

    public void attach(Observer observer);

    /**
     * 删除观察者
     * @param observer
     */
    public void detach(Observer observer);

    /**
     * 通知观察者更新消息
     * @param message
     */

    public void notify(String message);
}
