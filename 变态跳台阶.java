import java.util.Scanner;

public class solution {
    // f(n-1) = f(0) + f(1) + f(2) + … + f((n-1)-1) = f(0) + f(1) + f(2) + … + f(n-2)
    // f(n) = f(0) + f(1) + f(2) + … + f(n-2) + f(n-1) = f(n-1) + f(n-1)
    // 则有：f(n) = 2 * f(n-1)
    public static int JumpFloorII(int target) {
        int sum = 0;
        if(target == 1){
            sum = 1;
        }
        if(target > 1){
            sum = 2 * JumpFloorII(target-1);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        System.out.println("跳法：" + JumpFloorII(target) + "次");
    }
}
