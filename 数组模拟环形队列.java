import java.util.Scanner;

public class CircleArrayQueneDemo {
    public static void main(String[] args) {
        CircleArray circleArray = new CircleArray(4);
        char key = ' ';  //接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出");
            System.out.println("a(add):添加数据");
            System.out.println("g(get):取出数据");
            System.out.println("h(head):查看头部数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    circleArray.showQueue();
                    break;
                case 'a':
                    System.out.println("请添加一个数据");
                    int value = scanner.nextInt();
                    circleArray.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = circleArray.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int res = circleArray.headQueue();
                        System.out.printf("队列头的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
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

//使用数组模拟队列：编写一个ArrayQueue类
class CircleArray{
    private int maxSize;  //表示数组的最大容量
    private int front;  //指向队列头
    private int rear;  //指向队列尾
    private int[] arr;  //该数组用于存放数据--->模拟队列

    //1.创建队列的构造器
    public CircleArray(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        //front和rear默认值就是0，不用重新初始化
    }

    //2.判断队列是否满
    public boolean isFull(){
        return (rear+1)% maxSize == front;
    }

    //3.判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //4.添加数据到队列
    public void addQueue(int n){
        //判断队列是否满
        if(isFull()){
            System.out.println("队列已满，不能继续加入数据");
            return;
        }
        //直接将数据加入
        arr[rear] = n;
        rear = (rear + 1) % maxSize;  //防止越界
    }

    //5.获取数据：出队列
    public int getQueue(){
        //判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法获取数据");
        }
        //1.先把front对应值保存到临时变量
        //2.将front后移
        //3.返回临时变量
        int value = front;
        front = (front + 1) % maxSize;  //防止越界
        return arr[value];
    }

    //6.展示队列的所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        //思路：从front开始遍历，遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n",i % maxSize,arr[i]);
        }
    }

    //7.求出当前队列有效数据的个数
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    //7.显示队列的头数据（不取）
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
}
