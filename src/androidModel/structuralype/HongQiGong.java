package androidModel.structuralype;

public class HongQiGong extends Master{
    public HongQiGong(Swordsman swordsman) {
        super(swordsman);
    }

    public void teachAttackMagic(){
        System.out.println("洪七公教杨过武功");
    }

    @Override
    public void attackMagic() {
        super.attackMagic();
        teachAttackMagic();
    }
}
