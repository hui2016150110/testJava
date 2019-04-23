package androidModel.actiontype;

public class Strong implements FightingStrategy{
    @Override
    public void fighting() {
        System.out.println("使用对付强者的策略");
    }
}
