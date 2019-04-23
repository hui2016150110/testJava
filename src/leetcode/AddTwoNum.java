package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddTwoNum {


    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = false;
        for(int i = 0;i<str.length();i++){
            if(chars[i]=='-'){
                if(stringBuilder.indexOf("-")==-1&&stringBuilder.indexOf("+")==-1)
                    stringBuilder.append(chars[i]);
                else
                    break;
            }
            else if(chars[i]=='+'){
                if(stringBuilder.indexOf("-")==-1&&stringBuilder.indexOf("+")==-1)
                    stringBuilder.append(chars[i]);
                else
                    break;
            }
            else if(chars[i]>='0'&&chars[i]<='9'){
                flag = true;
                stringBuilder.append(chars[i]);
            }
            else if(chars[i]==' '&&stringBuilder.length()==0) continue;
            else break;
        }
        if(flag){
            int result = -2147483648;
            try {
                result = Integer.parseInt(stringBuilder.toString());
            }catch (Exception e){
                return stringBuilder.indexOf("-")<0?-2147483648:2147483647;
            }finally {
                return result;
            }
        }

        else return 0;

    }
    public int maxArea(int[] height) {
        int left = 0,right = height.length-1;
        int max = 0;
        while (left<right){
           int area =(right-left)*Math.min(height[left],height[right]);
           if(area>max)
               max = area;
           if(height[left]<height[right])
               left++;
           else
               right--;
        }
        return max;

    }

}
