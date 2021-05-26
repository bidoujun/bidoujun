package sjjgysf;

public class InsertValSearch {
    public static void main(String[] args) {
        int[] array={1,2,5,6,8,9};
        int value=binarySearch(array,5,0,array.length-1);
        System.out.println(value);
    }
    //插入查找
    public static int binarySearch(int[] array,int value,int left,int right){
        if(left>right||value<array[left]||value>array[right]){
            return -1;
        }
        int mid=left+(right-left)*(value-array[left])/(array[right]-array[left]);
        int minVal=array[mid];
        //如果要查找的值大于中间值 那么向右递归
        if(value>minVal){
            return binarySearch(array,value,mid+1,right);
        }else if(value<minVal){
            return binarySearch(array,value,left,mid-1);
        }else{
            return mid;
        }
    }
}
