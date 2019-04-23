package programLanguage.nqueen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NQueen {
    static int size = 0;
    static int count = 0;
    ArrayList<List<Location>> countList = new ArrayList<>();
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入m皇后的问题的规模：");
        size = input.nextInt();

        ArrayList<Location> locationArrayList = new ArrayList<>();
        NQueen nQueen = new NQueen();
        nQueen.nQueen(locationArrayList,0,0);
        System.out.println(count);
        for (List<Location> list:nQueen.countList){
            for(Location location : list){
                System.out.println(location.x+" "+location.y);
            }
            System.out.println();
        }
    }

    //判断位置是不是合法
    public boolean isIllegal(ArrayList<Location> list,Location location){
        for(Location each:list){
            if(each.x==location.x||each.y==location.y){
                return false;
            }else if(Math.abs(location.x-each.x)==Math.abs(location.y-each.y)){
                return false;
            }
        }
        return true;
    }

    public void nQueen(ArrayList<Location> list ,int x,int y){
        if(list.size()==size){
            count++;
            ArrayList<Location> clone = (ArrayList<Location>) list.clone();
            countList.add(clone);
            return;
        }
        for(int i = x;i<size;i++){
            Location location = new Location(i,y);
            if(isIllegal(list,location)){
                list.add(location);
                nQueen(list,0,y+1);
                list.remove(list.size()-1);
            }
        }
    }

}
