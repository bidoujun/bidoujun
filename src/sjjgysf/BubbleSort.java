package sjjgysf;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array={2,1,5,6,8,9,11};
        dubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
    //冒泡排序
    public static int[] dubbleSort(int[] array){
        int temp=0;
        boolean flag=false;
        for (int i = 0; i <array.length-1 ; i++) {
            for (int j = 0; j <array.length-1-i ; j++) {
                if (array[j] > array[j+1]){
                    flag=true;
                    temp=array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                }
            }
            //如果没有发生交换 说明是有序的 直接结束
            if(!flag){
                break;
            }else{
                flag=false;
            }
        }
        return array;
    }
}
