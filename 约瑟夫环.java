public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

        circleSingleLinkedList.conutBoy(1,2,5);

    }
}

//先创建一个Boy类，表示节点类
class Boy{
    private int num; //编号
    private Boy next;  //指向下一个节点，默认为空
    public Boy(int num){
        this.num = num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public void setNext(Boy next) {
        this.next = next;
    }
    public int getNum() {
        return num;
    }
    public Boy getNext() {
        return next;
    }
}

//创建一个单向环形链表
class CircleSingleLinkedList{
    //创建一个first节点，没有编号
    private Boy first = null;

    //添加节点，构建成一个环形链表
    public void addBoy(int nums){
        if(nums < 1){
            System.out.println("nums输入有误");
            return;
        }
        Boy curBoy = null;  //辅助指针，帮助构建环形链表
        //使用循环创建环形链表
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if(i == 1){
                first = boy;
                first.setNext((first));
                curBoy = first;
            }else {
                curBoy.setNext(boy);  //指向要添加的节点
                boy.setNext(first);  //新节点指向firs节点
                curBoy = boy;  //向后移动一个
            }
        }
    }

    //遍历环形链表
    public void showBoy(){
        if(first == null){
            System.out.println("环形链表为空");
            return;
        }
        Boy curBoy = first;
        while (true){
            System.out.printf("节点%d\n",curBoy.getNum());
            if(curBoy.getNext() == first){ //遍历完毕
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    //根据用户的输入，计算出出圈的顺序
    public void conutBoy(int startNum,int countNum,int nums){
        if(first == null || startNum < 1 || startNum > nums){
            System.out.println("输入有误");
            return;
        }
        //创建一个辅助指针，帮助完成出圈
        Boy helper = first;
        while (true){
            if(helper.getNext() == first){  //helper指向了最后一个节点
                break;
            }
            helper = helper.getNext();
        }
        //先让first和helper移动startNum-1次
        for(int j = 0;j < startNum-1;j++){
            first = first.getNext();
            helper = helper.getNext();
        }
        //数数时，让first和helper同时移动countNum-1次，然后出圈
        //直到圈中只有一个节点
        while (true){
            if(helper == first){  //只剩一个节点
                break;
            }
            for(int j = 0; j < countNum-1;j++){
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("节点%d出圈\n",first.getNum());
            //删除节点
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留下的是%d\n",first.getNum());
    }
}









