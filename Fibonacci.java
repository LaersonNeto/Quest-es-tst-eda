import java.util.*;

class Fibonacci {
    public static int fibonacci(int num){
        if (num <= 1) return num;
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(fibonacci(num));
    }
}

