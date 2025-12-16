import java.util.*;

class RadixTresDigitos{

    public static void radixTres(int[] v, int d){
        int exp = 1;
        for(int i = 0; i < d/3; i++){
            counting(v, exp);
            exp *= 1000;
        }
    }

    public static void counting(int[] v, int exp){
        int[] count = new int[1000];
        int[] aux = new int[v.length];

        for(int i = 0; i < v.length; i++){
            int digit = (v[i] / exp) % 1000; 
            count[digit]++;
        }

        for(int i = 1; i < 1000; i++)
            count[i] += count[i - 1];

        for(int i = v.length - 1; i >= 0; i--){
            int digit = (v[i] / exp) % 1000;
            aux[count[digit] - 1] = v[i];
            count[digit]--;
        }
    
        for (int i = 0; i < v.length; i++)
            v[i] = aux[i];

        System.out.println(Arrays.toString(v));
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] v = new int[input.length];
        
        for(int i = 0; i < v.length; i++)
            v[i] = Integer.parseInt(input[i]);

        int digit = sc.nextInt();
        
        radixTres(v, digit);
    }
}
