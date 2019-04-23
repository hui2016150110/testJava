package programLanguage.nqueen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NQueen2 {
    static int size = 0;
    static int count = 0;
    ArrayList<List<Location>> countList = new ArrayList<>();
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入m皇后的问题的规模：");
        size = input.nextInt();
        ArrayList<Location> locationArrayList = new ArrayList<>();
        NQueen2 nQueen2 = new NQueen2();
        nQueen2.nqueen(locationArrayList);
        System.out.println(nQueen2.countList.size());

    }
    public void nqueen(ArrayList<Location> list){
        int row = 0,column = 0;
        while (row<size){
            boolean flag = false;
            while (column<size){
                Location location = new Location(row,column);
                //合法位置
                if(isIllegal(list,location)){
                    list.add(location);
                    column = 0;
                    flag = true;
                    break;
                }else{
                    column++;
                }
            }
            if(!flag){
                if(row==0){
                    break;
                }
                row--;
                column = list.get(list.size()-1).y+1;
                list.remove(list.size()-1);
                continue;
            }
            if(list.size()==size){
                for(Location location:list){
                    System.out.println(location.x+" "+location.y);
                }
                System.out.println();
                ArrayList<Location> clone = (ArrayList<Location>) list.clone();
                countList.add(clone);
                column = list.get(list.size()-1).y+1;
                list.remove(list.size()-1);
                continue;
            }
            row++;
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
}
