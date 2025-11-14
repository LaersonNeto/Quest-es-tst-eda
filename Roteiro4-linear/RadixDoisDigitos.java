import java.util.*;

class RadixDoisDigitos{

    public static void radixDois(int[] v, int d){
        int exp = 1;
        for(int i = 0; i < d/2; i++){
            counting(v,exp);
            exp*= 100;
        }
    }

    public static void counting(int[] v, int exp){
        int[] count = new int[100];
        int[] aux = new int[v.length];

        for(int i = 0; i < v.length; i++)
            count[(v[i] / exp) % 100]++;

        for(int i = 1; i < 100; i++)
            count[i] += count[i - 1];

        for(int i = v.length -1; i >= 0; i--){
            aux[count[(v[i] / exp) % 100] -1] = v[i];
            count[(v[i] / exp) % 100]--;
        }

        for(int i = 0; i < v.length; i++)
            v[i] = aux[i];

        System.out.println(Arrays.toString(v));
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] v = new int[input.length];
        
        for(int i = 0; i < v.length; i++)
            v[i] = Integer.parseInt(input[i]);

        int d = sc.nextInt();

        radixDois(v, d);
    }
}
