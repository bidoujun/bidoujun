package sjjgysf;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array={1,2,5,6,8,9};
        int value=binarySearch(array,66,0,array.length-1);
        System.out.println(value);
    }
    public static int binarySearch(int[] array,int value,int left,int right){
        if(left>right){
            return -1;
        }
        int mid=(left+right)/2;
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
    public static int binarySearch(int[] arr,int key){
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;			//定义mid
        //key大于最大小于最小 或者数组时空的 返回-1
        if(key < arr[low] || key > arr[high] || low > high){
            return -1;
        }
        while(low <= high){
            mid = (low + high) / 2;
            if(arr[mid] > key){
                //比关键字大则关键字在左区域
                high = mid - 1;
            }else if(arr[mid] < key){
                //比关键字小则关键字在右区域
                low = mid + 1;
            }else{
                return mid;
            }
        }
        //最后仍然没有找到，则返回-1
        return -1;
    }
}
