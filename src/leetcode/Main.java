package leetcode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            long num = input.nextLong();
            long ability = input.nextInt();
            long monster[] = new long[(int)num];
            for(int i = 0;i<num;i++){
                monster[i] = input.nextInt();
            }
            for(int i = 0;i<num;i++){
                if(ability>=monster[i])
                    ability+=monster[i];
                else
                    ability+=big(ability,monster[i]);
            }
            System.out.println(ability);

        }

    }

    public static long big(long m,long n){

        while(m%n!=0){
            long temp = m%n;
            m = n;
            n = temp;
        }
        return n;
    }


}






