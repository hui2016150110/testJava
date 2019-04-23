package androidModel.structuralype;

public class OuYangFeng extends Master{


    public OuYangFeng(Swordsman swordsman) {
        super(swordsman);

    }

    public void teachAttackMagic(){
        System.out.println("欧阳锋教杨过武功");
    }

    @Override
    public void attackMagic() {
        super.attackMagic();
        teachAttackMagic();
    }
}
