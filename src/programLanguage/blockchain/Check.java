package programLanguage.blockchain;

import java.util.ArrayList;

public class Check {
    public static boolean checkBlock(Block block,int index){
        if(index==1){
            if(block.myHash.equals(StringHash.createHash("0"+block.getDate()+block.getTimeStamp())))
                return true;
        }else{
            if(block.myHash.equals(StringHash.createHash(block.preHash+block.getDate()+block.getTimeStamp())))
                return true;
        }
        return false;
    }
    public static boolean checkList(String preHash,long timeStamp,String data,int index,String myHash){
        if(index==1){
            if(myHash.equals(StringHash.createHash("0"+data+timeStamp)))
                return true;
        }else{
            if(myHash.equals(StringHash.createHash(preHash+data+timeStamp)))
                return true;
        }
        return false;
    }
}
