package sjjgysf;

import static javafx.scene.input.KeyCode.L;

public class LinkedList {
    public static void main(String[] args) {
        StudentNode s=new StudentNode(1,"张三","18","男");
        StudentNode s1=new StudentNode(2,"李四","15","女");
        StudentNode s2=new StudentNode(3,"王五","30","男");
        StudentNode s3=new StudentNode(4,"赵六","20","男");
        StudentList sList=new StudentList();
        sList.addyue(5);
        sList.countStudent(1,2,5);
        System.out.println("==========================");

    }
}
//约瑟夫问题
class StudentList{
    private StudentNode head=new StudentNode(0,"","","");
    StudentNode first;
    StudentNode finall;
    public StudentNode getHead() {
        return head;
    }
    //约瑟夫问题

    /**
     *
     * @param startNo 从第几个开始数
     * @param count 数几次
     * @param nums 开始有几个
     */
    public void countStudent(int startNo,int count,int nums){
        if(first==null||startNo<1||startNo>nums){
            System.out.println("输入参数不对");
            return;
        }
        StudentNode temp=first;
        //先定位到最后一个元素
        while (true){
            if(temp.next==first){
                break;
            }
            temp=temp.next;
        }
        //将最后一个元素和第一个元素移动stratNo
        for (int i = 0; i <startNo-1 ; i++) {
            first=first.next;
            temp=temp.next;
        }
        while (true){
            if(temp==first){
                break;
            }
            //每移动count-1输出id
            for (int i = 0; i <count-1 ; i++) {
                first=first.next;
                temp=temp.next;
            }
            System.out.println(first.id);
            first=first.next;
            temp.next=first;
        }
        System.out.println("最后一个是"+first.id);

    }
    public void addyue(int nums){
        if(nums<0){
            System.out.println("添加的数量有误");
            return;
        }
        StudentNode curStudent = null;
        for (int i = 1; i <= nums; i++) {
            StudentNode studentNode=new StudentNode(i);
            if(i==1){
                first=studentNode;
                first.next=first;
                curStudent=first;
            }else{
                curStudent.next=studentNode;
                studentNode.next=first;
                curStudent=studentNode;
            }

        }
    }
    //环形链表
    public void addHuan(StudentNode studentNode){
        if(first==null){
            first=studentNode;
            studentNode.next=first;
        }
        StudentNode temp=first;
        while(true){
            if(temp.next==first){
                break;
            }
            temp=temp.next;
        }
        temp.next=studentNode;
        studentNode.next=first;
    }
    public void searchHuan(){
        StudentNode temp=first;
        if(first==null){
            System.out.println("链表为空");
        }
        while(true){
            if(temp.next==first){
                System.out.println(temp.id);
                break;
            }
            System.out.println(temp.id);
            temp=temp.next;
        }
    }

    //链表添加
    public void add(StudentNode studentNode){
        StudentNode temp=head;
        //找到链表最后一个元素
        while (true){
            if(temp.next==null){
                break;
            }
            //指针后移
            temp=temp.next;
        }
        //把元素添加到链表的最后
        temp.next=studentNode;
    }
    //链表遍历
    public void search(){
        StudentNode temp=head.next;
        if(head.next==null){
            System.out.println("链表是空的");
            return;
        }
        while(true){
            if(temp==null){
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }
    //根据Id顺序添加
    public void addById(StudentNode studentNode){
        StudentNode temp=head;
        //判断Id是否存在
        boolean flag=false;
        while(true){
            if(temp.next==null){
                break;
            }
            if(studentNode.id==temp.id){
                flag=true;
                break;
            }
            if(studentNode.id<temp.next.id){
                break;
            }
            temp=temp.next;
        }
        if(flag){
            System.out.println("添加学生Id已存在"+studentNode);
        }
        studentNode.next=temp.next;
        temp.next=studentNode;
    }
    //根据id修改链表
    public void update(StudentNode studentNode){
        StudentNode temp=head.next;
        if(temp==null){
            System.out.println("链表为空");
            return;
        }
        //是否找到节点
        boolean flag=false;
        while (true){
            if(temp==null){
                break;
            }
            if(temp.id==studentNode.id){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            temp.age=studentNode.age;
            temp.name=studentNode.name;
            temp.sex=studentNode.sex;
        }
        System.out.println("没找到相同Id"+studentNode);
    }
    //删除节点
    public void delete(int id){
        StudentNode temp=head;
        boolean flag=false;
        while(true){
            //找到节点
            if(temp.next.id==id){
                flag=true;
                break;
            }
            if(temp==null){
                break;
            }
            temp=temp.next;
        }
        //将temp的下一个节点赋值为下下个节点 利用垃圾回收机制删除节点
        if(flag){
            temp.next=temp.next.next;
        }else {
            System.out.println("没有找到节点,节点已经删除");
        }
    }
    //根据Id查询链表
    public void searchById(int id){
        StudentNode temp=head.next;
        boolean flag=false;
        if(temp==null){
            System.out.println("链表是空的");
        }
        while(true){
            if(temp==null){
                break;
            }
            if(temp.id==id){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            System.out.println(temp);
        }else{
            System.out.println("没找到该元素");
        }
    }
    //单链表反转
    public static void fzLinkedList(StudentNode head){
        //如果是空链表,或者链表只有一个元素 则不用反转
        if(head.next==null||head.next.next==null){
            return;
        }
        StudentNode newhead=new StudentNode(0,"","","");
        StudentNode cur = head.next;
        StudentNode next=null;
        while(cur!=null){
            //保存cur后面的元素
            next=cur.next;
            //把新头节点后面的元素放到遍历元素的后面
            cur.next=newhead.next;
            //把遍历出来的元素添加到新的头节点后面
            newhead.next=cur;
            //指针后移
            cur=next;
        }
        //将反转后的数据接到head后面
        head.next=newhead.next;
    }
}
class StudentNode{
    public StudentNode(int id) {
        this.id = id;
    }

    int id;
    String name;
    String age;
    String sex;
    StudentNode next;
    public StudentNode(int id,String name, String age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.id=id;
    }
    @Override
    public String toString() {
        return "StudentNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
