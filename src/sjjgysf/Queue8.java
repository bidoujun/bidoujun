package sjjgysf;
/*通过不断回溯一个一个试出来的,到了第八层以后未成功会在第8层数组一个个试直到return,
 *return是又返回到第七层,第七层接着往下遍历.如果第七层满足条件又会调用添加棋子的方法进行
 *添加.同理第七层return后第六层也一样直到return到第一层结束.递归结束,
 *利用压栈的执行原理,将所有结果都试出来.
 */
public class Queue8 {
    int max=8;
    int[] array=new int[max];
    public static void main(String[] args) {
        Queue8 q=new Queue8();
        q.queue(0);
    }
    public void queue(int n){
        //n等于8路径成功
        if(n==max){
            print();
            return;
        }
        //不等于8说明未成功 让它在第n层从0到max-1不断的试
        for(int i=0;i<max;i++){
            array[n]=i;
            //依次判断是否冲突 不冲突说明n层放对了,接着放下一层
            if(judge(n)){
                queue(n+1);
            }
        }
    }
    public boolean judge(int n){
        for(int i=0;i<n;i++){
            //如果后面添加的元素和n在同一条直线或者同意条斜线上 根据数学知识,行和列的绝对值相等就是等腰三角形在同一条直线上
            if(array[i]==array[n]||Math.abs(array[n]-array[i])==Math.abs(n-i)){
                return false;
            }
        }
        return true;
    }
    public void print(){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
