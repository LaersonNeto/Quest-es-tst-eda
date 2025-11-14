import java.util.*;

class QuickSort{
    
    public static void quickSort(int[] v, int ini, int fim){
        if (ini < fim){
            int ind_pivot = particiona(v, ini, fim);
            quickSort(v, ini, ind_pivot - 1);
            quickSort(v, ind_pivot + 1, fim);
        }
    }

    private static int particiona(int[]v, int ini, int fim){
        int pivot = v[ini];
        int i = ini + 1;
        int j = fim;
        
        while(j >=  i){
            while(j >= i && v[i] <= pivot) i++;
            while(j >= i && v[j] > pivot) j--; 
            if(i < j){
                int aux = v[i];
                v[i] = v[j];
                v[j] = aux;
            }
        }
        int aux = v[j];
        v[j] = v[ini];
        v[ini] = aux;
    
        printa(v);
        return j;
    }

    private static void printa(int[] v){
        for(int i = 0; i < v.length; i++){
            System.out.print(v[i]);
            if(i < v.length - 1) System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] nums = new int[input.length];
        for(int i = 0; i < input.length; i++) 
            nums[i] = Integer.parseInt(input[i]);
        quickSort(nums, 0, nums.length - 1);
    }
}
