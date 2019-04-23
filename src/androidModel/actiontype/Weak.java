package androidModel.actiontype;

public class Weak implements FightingStrategy{
    @Override
    public void fighting() {
        System.out.println("使用对付弱者的策略");
    }
}
