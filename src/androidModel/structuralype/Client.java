package androidModel.structuralype;

public class Client {
    public static void main(String[] args){
        YangGuo yangGuo = new YangGuo();
        HongQiGong hongQiGong = new HongQiGong(yangGuo);
        hongQiGong.attackMagic();

    }
}
