package androidModel.actiontype;

public class Common implements FightingStrategy{
    @Override
    public void fighting() {
        System.out.println("使用对付普通对手的策略");
    }
}
