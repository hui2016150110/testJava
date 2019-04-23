package androidModel.actiontype;

public abstract class AbstractSwordman {
    //该方法为final，防止算法框架被覆写
    public final void fighting(){
        neigong();
        meridian();
        if(hasWeapons()){
            weapons();
        }

        moves();
        hook();
    }

    //空实现方法
    protected void hook(){};
    protected abstract void neigong();
    protected abstract void weapons();
    protected abstract void moves();
    protected void meridian(){
        System.out.println("开启正经与奇经");
    }

    protected boolean hasWeapons(){
        return true;
    }
}
