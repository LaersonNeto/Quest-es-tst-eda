import java.util.*;

class CountingSortNegativos{

    public static void countingNegativos(int[] v, int max, int min){
        int[] count = new int[max - min + 1];
        int[] output = new int[v.length];
        
        for(int i = 0; i < v.length; i++){
            count[v[i] - min]++;
            System.out.println(Arrays.toString(count));
        }
        
        for(int i = 1; i < count.length; i++)
            count[i] += count[i - 1];

        System.out.print("Cumulativa do vetor de contagem - ");
        System.out.println(Arrays.toString(count));

        for(int i = v.length - 1; i >= 0; i--){
            output[count[v[i] - min] - 1] = v[i];
            count[v[i] - min]--;
        }

        System.out.println(Arrays.toString(count));
        System.out.println(Arrays.toString(output));
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] v = new int[input.length];
        for(int i = 0; i < input.length; i++)
            v[i] = Integer.parseInt(input[i]);
        int max = sc.nextInt();
        int min = sc.nextInt();
        countingNegativos(v, max, min);
    }
}
