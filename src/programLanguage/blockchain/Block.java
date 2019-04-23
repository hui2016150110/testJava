package programLanguage.blockchain;

import java.util.Date;

//一个块，包含的信息：
public class Block {
    public String myHash;//自己的哈希值
    public String preHash;//前置哈希值
    private String data;//数据
    private long timeStamp;//时间戳
    public long index;//索引
    public Block(String preHash,String data,long index){
        this.index = index;
        this.data = data;
        this.preHash = preHash;
        this.timeStamp = new Date().getTime();
        this.myHash = StringHash.createHash(preHash+data+Long.toString(timeStamp));
        if(index==1){
            this.preHash = this.myHash;
        }
    }

    public String getDate(){
        return this.data;
    }

    public long getTimeStamp() {
        return timeStamp;
    }
}
