import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TestPriorityQueue {
    public static void CreatePriorityQueue(){
        //1.构造一个空的优先级队列
        //注意：空的优先级队列，但是底层已经有了11个默认空间
        //      capacity不能小于1；如果小于1，会抛出异常
        PriorityQueue<Integer> p1 = new PriorityQueue<>();

        //2.按照指定容量来进行构造
        //如果知道优先级队列中大概要放多少个元素时，就使用该方法进行构造
        //不要使用空的构造方式，因为在插入于是怒时需要不断扩容而影响程序的效率
        PriorityQueue<Integer> p2 = new PriorityQueue<>(20);

        //3.可以用一个集合来直接构造优先级队列
        //将来就会将集合中的元素放到优先级队列
        List<Integer> L = new ArrayList<>();
        L.add(0);
        L.add(1);
        L.add(2);
        L.add(3);
        L.add(4);
        PriorityQueue<Integer> p3 = new PriorityQueue<>(L);
        System.out.println(p3.size());
    }

    public static void TryPriorityQueue(){
        PriorityQueue<Integer> p = new PriorityQueue<>();
        //插入的元素一定要能够比大小，不能插入空对象
        //插入时会自动进行扩容
        //插入的时间复杂度O(log2N)
        //插入失败返回false
        //插入元素期间，优先级队列中的元素会进行调整，首元素一定是最小的
        p.offer(4); //插入一个元素
        p.offer(1);
        p.offer(3);
        p.offer(0);
        p.offer(5);
        p.offer(2);
        //peek()方法获取的是优先级队列中的第一个（最小的）元素
        System.out.println(p.peek());

        //删除一个元素：优先级队列中的第一个（最小的）元素
        //剩余元素会自动进行调整--->将剩余元素中最小的调整到首元素的位置
        //时间复杂度：O(log2N)
        p.poll();
        System.out.println(p.peek());
        p.poll();
        System.out.println(p.peek());

        //清空优先级队列
        p.clear();
        if(p.isEmpty()){
            System.out.println("优先级队列为空!");
        }else {
            System.out.println("优先级队列不为空!");
        }
    }

    public static void main(String[] args) {
        //CreatePriorityQueue();
        TryPriorityQueue();
    }
}
