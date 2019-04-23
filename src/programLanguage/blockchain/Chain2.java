package programLanguage.blockchain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

//不使用封装实现，通过两个list来实现
public class Chain2 {
    //主链
    static ArrayList<List> chainList = new ArrayList<>();
    //索引链
    static ArrayList<Integer> indexList = new ArrayList<>();
    //时间戳链
    static ArrayList<Long> timeList = new ArrayList<>();
    //自己的哈希链
    static ArrayList<String> myhashList = new ArrayList<>();
    //前置哈希链
    static ArrayList<String> prehashList = new ArrayList<>();
    //数据链
    static ArrayList<String> dataList = new ArrayList<>();

    public static void main(String[] args){
        Chain2 chain2 = new Chain2();
        chain2.addList();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要创建多少个块");
        int numBlock = input.nextInt();
        for(int i = 0;i<numBlock;i++){
            indexList.add(i+1);
            long time = new Date().getTime();
            timeList.add(time);
            System.out.println("请输入第"+(i+1)+"块的数据");
            String data = input.next();
            dataList.add(data);
            String myhash = null;
            String prehash = null;
            if(i==0){
                myhash = StringHash.createHash("0");
                prehash = myhash;
            }else{
                //当前块的哈希值是通过只一个块的哈希值创建
                myhash = StringHash.createHash(myhashList.get(i-1));
                prehash = myhashList.get(i-1);
            }
            myhashList.add(myhash);
            prehashList.add(prehash);
        }

        for(int i = 0;i<numBlock;i++){
            System.out.println("这是第"+(i+1)+"个块");
            System.out.println("本身的哈希值:"+myhashList.get(i));
            System.out.println("前置哈希值:"+prehashList.get(i));
            System.out.println("时间戳是:"+timeList.get(i));
            System.out.println("数据是:"+dataList.get(i)+"\n");
        }

    }

    private void addList(){
        chainList.add(indexList);
        chainList.add(myhashList);
        chainList.add(prehashList);
        chainList.add(dataList);
        chainList.add(timeList);
    }
}
