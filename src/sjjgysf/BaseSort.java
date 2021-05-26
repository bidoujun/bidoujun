package sjjgysf;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BaseSort {
    public static void main(String[] args) {
        int[] array=new int[30000000];
        for (int i = 0; i <30000000 ; i++) {
            array[i]=i;
        }
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String dataStr=simpleDateFormat.format(date);
        System.out.println(dataStr);
        baseSort(array);
        System.out.println(dataStr);

}
    /*
     *典型的用空间换时间的排序.3000+W数据时内存已经就不够了.
     *基数排序就是将个位数都取出来进行排序按照个位数的顺序放进数组,又将得到的数组按照十位数排序
     *以此类推最终将最高位排完以后就是一个有序的数组.
     */
    public static int[] baseSort(int[] array){
        int max=array[0];
        int[][] bucket=new int[10][array.length];
        int[] element = new int[10];
        //找出数组中的最大值
        for(int i=0;i<=array.length-1;i++){
            if(array[i]>max){
                max=array[i];
            }
        }
        int maxLength=(max+"").length();
        //循环使各个进制都被计算
        for(int l=0,n=1;l<maxLength;l++,n*=10){
            for(int j=0;j<=array.length-1;j++){
                //取出元素对应进制中的值
                int digit=array[j] / n % 10;
                //element[digit]是放置元素的个数 digit是对应进制的下标 将每个元素放置在他对应的桶中
                bucket[digit][element[digit]]=array[j];
                element[digit]++;
            }
            //将对应桶中的元素取出来放置到原来的数组中;遍历桶
            int index=0;
            for(int k=0;k<element.length;k++){
                if(element[k]!=0){
                    //如果桶有数据
                    for (int i = 0; i <element[k] ; i++) {
                        array[index]=bucket[k][i];
                        index++;
                    }
                }
                //取完数据将桶内元素个数归零
                element[k]=0;
            }
        }return array;
    }
}
