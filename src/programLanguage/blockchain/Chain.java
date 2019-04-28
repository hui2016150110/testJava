package programLanguage.blockchain;

import java.util.ArrayList;
import java.util.Scanner;

//将块封装来实现
public class Chain {
    private static ArrayList<Block> blockchain = new ArrayList<>();
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要创建多少个块");
        int numBlock = input.nextInt();
        for(int i = 0;i<numBlock;i++){
            System.out.println("请输入第"+(i+1)+"块的数据");
            String data = input.next();
            Block block = null;
            if(i==0){
                block = new Block("0",data,i+1);
            }
            else{
                block = new Block(blockchain.get(i-1).myHash,data,i+1);
            }
            blockchain.add(block);
        }

        for(Block block:blockchain){
            System.out.println("这是第"+block.index+"块");
            System.out.println("本身的哈希值:"+block.myHash);
            System.out.println("前置哈希值:"+block.preHash);
            System.out.println("时间戳是:"+block.getTimeStamp());
            System.out.println("数据是:"+block.getDate()+"\n");
        }
        System.out.println("是否需要检查块，输入Y检查");
        String isCheck = input.next();
        if(isCheck.equals("Y")){
            int i,j;
            System.out.println("请输入要检查的块");
            i = input.nextInt();
            if(i>numBlock||i<=0){
                System.out.println("输入块错误");
            }else{
                System.out.println("请输入需要修改的数据：");
                String data = input.next();
                Block block = blockchain.get(i-1);
                String preData = block.getDate();
                block.setData(data);
                if(Check.checkBlock(block,i)){
                    System.out.println("数据块"+i+"里面的数据没有被修改");
                }else {
                    System.out.println("数据块"+i+"里面的数据被修改");
                    System.out.println("从->"+preData+"变为->"+data);
                }
            }
        }

    }

}
