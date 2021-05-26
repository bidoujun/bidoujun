package sjjgysf;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int a= (int) (Math.random()*10);
        System.out.println(a);
        int b=a+1;
        int[] array={5,2,78,6,9,10};
        insertSort2(array);
        System.out.println(Arrays.toString(array));
    }
    //注:没有break的插入都不是插入 可能是在有序数组后面加了一个数又进行冒泡排序去了.
//数组的第一个元素看作有序数组,从第二个元素开始插入.
    public static int[] insertSort2(int[] array){
        int j=0;
        //array[i]是有序数组和无序数组的分界点
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            for ( j = i; j>0 ; j--) {
                //倒序遍历有序找大于分界点的值,找到结束.没找到遍历过的都后移
                if( temp < array[j - 1]){
                    break;
                }else{
                    array[j]=array[j-1];
                }
            }
            //将分界点保存的值插入到找到元素的下一个位置
            array[j]=temp;
        }
        return array;
    }
    public static int[] insertSort(int[] array){

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j=i;
            while(j>0&&array[j-1]>temp ){
                array[j]=array[j-1];
                j--;
            }
            array[j]=temp;
        }
        return array;
    }
}
