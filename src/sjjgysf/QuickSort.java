package sjjgysf;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array={0,-5,5,9,15,65,1,23,456,3};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
    /*
     *快速排序是选定一个基准点 定义两个指针 从左到右和从右到左遍历,找到左边大于基准点
     *和右边小于基准点的下标将他俩交换 继续找,知道两个指针相遇停止,相遇点就是基准点的位置
     *将基准点和相遇位置进行交换 这样就通过基准点分割成两个数组,基准点左边是小于基准点的数组,
     *基准点右边是大于基准点的数组.通过不断的递归最终使数组完成排序
     */
    public static void quickSort(int[] array, int low, int high){
        int temp;
        int i,j,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //选最左边作为基准点;
        temp=array[low];
        //左边大于右边说明已经跑完

        while(i<j){
            while(i<j&&temp<=array[j]){
                j--;
            }
            while (i<j&&temp>=array[i]){
                i++;
            }
            //上面出来并且i<j 说明找到i和j即左边大于temp和右边小于temp的下标,将他们俩个换位
            if(i<j){
                t=array[j];
                array[j]=array[i];
                array[i]=t;
            }
        }
        //最后让基准与i或j下标互换
        array[low]=array[i];
        array[i]=temp;
        //基准左边调用递归
        quickSort(array,low,j-1);
        //基准右边调用递归
        quickSort(array,j+1,high);
    }
}
