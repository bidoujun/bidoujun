package sjjgysf;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] array={9,5,6,3,8,7,4,2,1,0};
        ShellSort2(array);
        System.out.println(Arrays.toString(array));
    }
    //交换法
    public static int[] ShellSort(int[] array){
        int temp=0;
        for (int i=array.length/2;i>0;i=i/2){
            for(int j=i;j<array.length;j++){
                for (int k = j-i; k >=0 ; k-=i) {
                    if(array[k]>array[k+i]){
                        temp=array[k];
                        array[k]=array[k+i];
                        array[k+i]=temp;
                    }
                }
            }
        }
        return array;
    }
    //移位法
    public static int[] ShellSort2(int[] array){
        for (int i=array.length/2;i>0;i=i/2){
            for(int j=i;j<array.length;j++){
               int k=j;
               int temp=array[k];
               if(array[k]<array[k-i]){
                   while (k-i>=0 &&temp<array[k-i]){
                       array[k]=array[k-i];
                       k -= i;
                   }
                   array[k]=temp;
               }
            }
        }
        return array;
    }
}
