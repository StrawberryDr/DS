import java.util.Scanner;

public class Main {
    public static int Add(int num1,int num2){
        while (num2!=0){
            int sum = num1 ^ num2;
            int temp = (num1 & num2)<<1;
            num1 = sum;
            num2 = temp;
        }
        return num1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        System.out.println(Add(num1,num2));
    }
}
