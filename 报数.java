import java.util.Scanner;

public class TestDemo {
    public static String countAndSay(int n) {

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String ret = countAndSay(n);
        System.out.println(ret);
    }
}
