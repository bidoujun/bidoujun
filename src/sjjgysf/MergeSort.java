package sjjgysf;

import java.util.Arrays;

/*
 *归并排序先将数组分成一个个,利用递归结束后从后往前执行的原理,先分后治.完成排序
 *合并的时候定义两个指针分别指向要合并的两个数组的最左边.比较两个大小,哪个大
 *就把哪个加到临时数组中并且指针右移.一个数组全部加完后将剩下数组没加完的全部
 *扔到临时数组中,即可完成两个数组的合并,通过递归的原理,使所有分开的数组都完成
 *合并,最终完成数组排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array={8,4,5,7,1,3,6,2};
        int[] temp=new int[array.length];
        int left=0;
        int right=array.length-1;
        mergeSort(array,left,right,temp);
        System.out.println(Arrays.toString(array));
    }
    public static void mergeSort(int[]array,int left,int right,int[]temp){
        if(left<right){
            int mid=(left+right)/2;
            //左边递归分
            mergeSort(array,left,mid,temp);
            //右边分
            mergeSort(array,mid+1,right,temp);
            merge(array,left,mid,right,temp);
        }

    }

    public static void merge(int[] array,int left,int mid,int right,int[]temp){
        int i=left;
        int j=mid+1;
        int t=0;
        //左边没结束或者右边没结束就一直排
        while(i<=mid&&j<=right){
            //哪边小就往数组里面存哪边
            if(array[i]<=array[j]){
                temp[t]=array[i];
                t++;
                i++;
            } else{
                temp[t]=array[j];
                t++;
                j++;
            }
        }
        //左边没排完或者右边没排完直接加到数组后面
        while(i<=mid){
            temp[t]=array[i];
            i++;
            t++;
        }
        while(j<=right){
            temp[t]=array[j];
            j++;
            t++;
        }
        t=0;
        //排序后把temp数组种的拷贝到array种
        int tempLeft=left;
        while(tempLeft<=right){
            array[tempLeft]=temp[t];
            t++;
            tempLeft++;
        }
    }
}

