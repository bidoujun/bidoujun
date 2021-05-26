package sjjgysf;

import java.util.Scanner;
//栈实现计算器
public class Computer {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.next();
        Stack2 opers=new Stack2(10);
        Stack2 nums=new Stack2(10);
        int num1=0;
        int num2=0;
        char oper=0;
        int result=0;

        char[] a=str.toCharArray();
        for (int i = 0; i <a.length; i++) {
            //判断是不是符号
            if(Stack2.isOper(a[i])){
                //符号栈不为空就比较当前符号与栈顶符号,如果当前符号优先级小于栈顶符号就先计算栈顶符号
                //从数字栈中弹出两个,从符号栈中弹出一个进行计算兵将结果加入数字栈.最后将符号入栈
                if(!opers.isEmpty()){
                    if(opers.fuHao(a[i])<=opers.fuHao((char) opers.getTop())){
                        num1=nums.pop();
                        num2=nums.pop();
                        oper= (char) opers.pop();
                        result=nums.jiSuan(num1,num2,oper);
                        nums.push(result);
                        opers.push(a[i]);
                    }else{
                        opers.push(a[i]);
                    }
                }else{
                    //是空入栈
                    opers.push(a[i]);
                }
            }else{
                nums.push(a[i]-48);
            }
        }
        //过滤完毕后符号栈就只剩+-进行计算即可.
        while (true){
            if(opers.isEmpty()){
                break;
            }
            num1=nums.pop();
            num2=nums.pop();
            oper= (char) opers.pop();
            result=nums.jiSuan(num1,num2,oper);
            nums.push(result);
        }
        System.out.println(nums.pop());
    }

}
class Stack2{
    int top=-1;
    int maxSize;
    int stack[];

    public Stack2() {
    }
    public int getTop(){
        return stack[top];
    }

    public Stack2(int maxSize) {
        this.stack = new int[maxSize];
        this.maxSize=maxSize;
    }
    public boolean isFull(){
        return top==maxSize-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    //压栈
    public void push(char node){
        if(isFull()){
            System.out.println("栈已满");
        }
        top++;
        stack[top]=node;
    }
    //压栈
    public void push(int node){
        if(isFull()){
            System.out.println("栈已满");
        }
        top++;
        stack[top]=node;
    }
    //弹栈
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        int node=stack[top];
        top--;
        return node;
    }
    //遍历栈
    public void search(){
        if(isEmpty()){
            System.out.println("栈空");
        }
        for (int i = top; i >=0 ; i--) {
            System.out.println(stack[i]);
        }
    }
    public int fuHao(char oper){
        if(oper=='*'||oper=='/'){
            return 1;
        }else if (oper=='+'||oper=='-'){
            return 0;
        }else{
            return -1;
        }
    }
    public static boolean isOper(char val){
        return val=='*'||val=='/'||val=='+'||val=='-';
    }
    public int jiSuan(int num1,int num2,char oper){
        int result = 0;
        switch (oper){
            case '+' :
                result=num1+num2;
                break;
            case '-' :
                result=num2-num1;
                break;
            case '*' :
                result=num1*num2;
                break;
            case '/' :
                result=num2/num1;
                break;
            default:
                break;
        }
        return result;
    }
}
