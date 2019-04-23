package struct;

import java.util.Random;

public class TestHeap {
    private int[] arr;
    private int N = 0;
    //上浮
    private void swim(int k){
        while (k>1&&arr[k]>arr[k/2]){
            exch(k,k/2);
            k = k/2;
        }
    }
    private void exch(int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //下沉
    private void sink(int k){
        while (2*k<=N){
            int j = 2*k;
            if(j<N&&arr[j]<arr[j+1]) j++;
            if(arr[k]>arr[j]) break;
            exch(k,j);
            k = j;
        }
    }

    public boolean isEmpty(){
        return N==0;
    }

    public void insert(int key){
        arr[++N] = key;
        swim(N);
    }

    public TestHeap(int arr[]){
        this.arr = arr;
        N = arr.length-1;

    }
    public static void main(String[] args){
        Random random = new Random();
        int[] testarr = new int[11];
        for(int i = 1;i<11;i++){
            testarr[i] = random.nextInt(10)+1;
        }

        TestHeap testHeap = new TestHeap(testarr);
        int length = testarr.length;

        for(int k = length/2;k>=1;k--){
            testHeap.sink(k);
        }

        while (testHeap.N>1){
            testHeap.exch(1,testHeap.N--);
            testHeap.sink(1);
        }for(int i = 1;i<11;i++){
            System.out.print(testarr[i]+" ");
        }

    }
}
