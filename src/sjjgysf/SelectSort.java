package sjjgysf;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] array ={12,5,6,87,2};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }
public static int[] selectSort(int[] array){
    for(int i=0;i<array.length-1;i++) {
        int min=array[i];
        int minindex=i;
        for (int j = i+1; j <= array.length - 1 ; j++) {
            if (array[j] < min) {
                min = array[j];
                minindex = j;
            }
        }
        if(minindex != i){
            array[minindex]=array[i];
            array[i]=min;
        }
    }
    return array;
}

}
