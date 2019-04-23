package androidModel.actiontype;

public class ZhangWuji extends AbstractSwordman{
    @Override
    protected void neigong() {
        System.out.println("张无忌内功");
    }

    @Override
    protected void weapons() {

    }

    @Override
    protected void moves() {
        System.out.println("张无忌移动");
    }

    @Override
    protected boolean hasWeapons() {
        return false;
    }
}
