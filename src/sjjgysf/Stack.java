package sjjgysf;

public class Stack {
    int top=-1;
    int maxSize;
    int stack[];
    public Stack(int maxSize) {
        this.stack = new int[maxSize];
    }
    public boolean isFull(){
        return top==maxSize-1;
    }
    public boolean isEmpty(){
        return top==-1;
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

}
