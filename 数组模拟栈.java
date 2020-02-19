import java.util.Scanner;

public class ArrayStaxkDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        String key = "";
        boolean loop = true;  //控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while (loop){
            System.out.println("show:显示栈");
            System.out.println("exit:退出");
            System.out.println("push:入栈");
            System.out.println("pop:出栈");
            System.out.println("请输入你的选择：");
            key = scanner.next();
            switch (key){
                case "show":
                    arrayStack.show();
                    break;
                case  "push":
                    System.out.println("请输入一个数：");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    try{
                        int res = arrayStack.pop();
                        System.out.printf("出栈的数据是：%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

//定义一个表示栈的类
class  ArrayStack{
    private int maxSize;  //栈的大小
    private int[] stack;  //模拟栈,数据放在该数组中
    private int top = -1;  //表示栈顶,初始值-1

    //构造器
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull(){
        return top == maxSize-1;
    }

    //栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(int value){
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈：需要从栈顶开始显示数据
    public void show(){
        if(isEmpty()){
            System.out.println("栈空");
            return;
        }
        for(int i = top;i >= 0;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}
