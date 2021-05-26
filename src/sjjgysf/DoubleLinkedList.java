package sjjgysf;

class hha{
    public static void main(String[] args) {
        StudentNode2 s=new StudentNode2(1,"张三","18","男");
        StudentNode2 s1=new StudentNode2(2,"李四","15","女");
        StudentNode2 s2=new StudentNode2(3,"王五","30","男");
        StudentNode2 s3=new StudentNode2(4,"赵六","20","男");
        DoubleLinkedList sList=new DoubleLinkedList();
        sList.add(s2);
        sList.add(s);
        sList.add(s3);
        sList.add(s1);
        sList.delete(2);
        sList.search();
        System.out.println("==========================");
        sList.nixuSearch();
    }
}
public class DoubleLinkedList {

    private StudentNode2 head=new StudentNode2(0,"","","");
    private StudentNode2 end;

    //链表遍历
    public void search(){
        StudentNode2 temp=head.next;
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
    //逆序遍历
    public void nixuSearch(){
        StudentNode2 temp=end;
        while(true){
            if(temp==head){
                break;
            }
            System.out.println(temp);
            temp=temp.pre;
        }
    }
    //链表添加
    public void add(StudentNode2 studentNode){
        StudentNode2 temp=head;
        //找到链表最后一个元素
        while (true){
            if(temp.next==null){
                break;
            }
            //指针后移
            temp=temp.next;
        }
        //把元素添加到链表的最后并且让元素的pre指向前一个元素
        temp.next=studentNode;
        studentNode.pre=temp;
        end=studentNode;
    }
    //删除节点
    public void delete(int id){
        StudentNode2 temp=head.next;
        boolean flag=false;
        while(true){
            //找到节点
            if(temp.id==id){
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
            temp.pre.next=temp.next;
            //防止Temp是最后一个元素出现空指针异常
            if(temp.next!=null){
                temp.next.pre=temp.pre;
            }else{
                //如果是最后一个元素 把end前移
                end=temp.pre;
            }
        }else {
            System.out.println("没有找到节点,节点已经删除");
        }
    }
    //根据id修改链表
    public void update(StudentNode2 studentNode){
        StudentNode2 temp=head.next;
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



}
class StudentNode2 {
    int id;
    String name;
    String age;
    String sex;
    StudentNode2 next;
    StudentNode2 pre;

    public StudentNode2(int id, String name, String age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.id = id;
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
