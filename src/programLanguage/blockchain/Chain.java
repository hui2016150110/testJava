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
//        Block firstBlock = new Block("0","I'm the first block",1);
//        blockchain.add(firstBlock);
//        Block secondBlock = new Block(firstBlock.preHash,"I'm the second block",blockchain.size()+1);
//        blockchain.add(secondBlock);
//        Block thirdBlock = new Block(secondBlock.myHash,"third",blockchain.size()+1);
//        blockchain.add(thirdBlock);

        for(Block block:blockchain){
            System.out.println("这是第"+block.index+"块");
            System.out.println("本身的哈希值:"+block.myHash);
            System.out.println("前置哈希值:"+block.preHash);
            System.out.println("时间戳是:"+block.getTimeStamp());
            System.out.println("数据是:"+block.getDate()+"\n");
        }

    }

}
