import java.util.*;

class RadixSort{

    public static void radixSort(int[] v, int maxDigit){
        int exp = 1;
        for(int i = 0; i < maxDigit; i++){
            countingSortDigit(v, exp);
            exp *= 10;
        } 
    }

    public static void countingSortDigit(int[] v, int exp){
        int[] count = new int[10];
        int[] aux = new int[v.length];

        for(int i = 0; i < v.length; i++)
            count[(v[i] / exp) % 10]++;

        for(int i = 1; i < count.length; i++)
            count[i] += count[i - 1];

        for(int i = v.length - 1; i >= 0; i--){
            aux[count[(v[i] / exp) % 10] - 1] = v[i];
            count[(v[i] / exp) % 10]--;
        } 

        for(int i = 0; i < v.length; i++)
            v[i] = aux[i];

        System.out.println(Arrays.toString(v));
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] v = new int[input.length];
        for(int i = 0; i < input.length; i++)
            v[i] = Integer.parseInt(input[i]);
        int maxDigit = sc.nextInt();
        radixSort(v, maxDigit);
    }
}
