import java.util.*;

class CountingSort{

    public static void countingSort(int[] v, int k){
        int[] count = new int[k + 1];
        
        for(int i = 0; i < v.length; i++){
            count[v[i]] += 1;
            printaArray(count);
        }

        for(int i = 1; i < count.length; i++)
            count[i] += count[i - 1];
    
        System.out.print("Cumulativa do vetor de contagem - ");
        printaArray(count);

        int[] output = new int[v.length];
        for(int i = v.length - 1; i >= 0; i--){
            output[count[v[i]] - 1] = v[i];
            count[v[i]]--;
        }
        
        printaArray(count);
        printaArray(output);
    }

    private static void printaArray(int[] v){
        for(int i = 0; i < v.length; i++){
            System.out.print(v[i]);
            if(i != v.length - 1) System.out.print(" ");
        }
        System.out.println();
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] v = new int[input.length];
        for(int i = 0; i < input.length; i++)
            v[i] = Integer.parseInt(input[i]);
        int k = sc.nextInt();
        countingSort(v, k);
    }
}
