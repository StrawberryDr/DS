package lesson1;

public class FirstLook {
//    public static void main(String[] args) throws InterruptedException {
////        Thread.sleep(99999999999L);
////    }

//    public static void main(String[] args) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //匿名内部类
//                try {
//                    Thread.sleep(99999999999L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//        //新创建一个线程，调用start方法进行启动
//    }

    public static void main(String[] args) {
        new Thread(new Runnable() {  //创建Thread和Runnable对象
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                //Thread.currentThread().getName()：获取当前代码行运行线程的名称
            }
        }).start();  //启动Thread-0线程
        System.out.println(Thread.currentThread().getName());  //main线程先执行
    }
}
