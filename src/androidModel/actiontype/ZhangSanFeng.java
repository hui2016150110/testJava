package androidModel.actiontype;

public class ZhangSanFeng extends AbstractSwordman{
    @Override
    protected void neigong() {
        System.out.println("张三丰内功");
    }

    @Override
    protected void weapons() {
        System.out.println("张三丰武器");
    }

    @Override
    protected void moves() {
        System.out.println("张三丰移动");
    }

    @Override
    protected void hook() {
        System.out.println("张三丰hook");
    }
}
