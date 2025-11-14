import java.util.*;

class MergeSort{
    
    public static void mergeSort(int[] v, int ini, int fim){     
        printSubarray(v, ini, fim);
        if(fim > ini){
           int mid = (fim + ini)/2;
           mergeSort(v, ini, mid);
           mergeSort(v, mid + 1, fim);
           merge(v, ini, fim);
        }        
    }

    public static void merge(int[] v, int ini, int fim){
        int fimNew = fim - ini;
        int[] helper = new int[fimNew + 1];
        for(int i = 0; i <= fimNew; i++) 
            helper[i] = v[ini + i];
        
        int midNew = (fimNew)/2;
        int i = 0;
        int j = midNew + 1;
        int k = ini;
        
        while(i <= midNew && j <= fimNew) {
            if(helper[i] <= helper[j]) v[k++] = helper[i++];
            else v[k++] = helper[j++]; 
        }

        while(i <= midNew) v[k++] = helper[i++];
        printSubarray(v, ini, fim);    
    }

    public static void printSubarray(int[] v, int ini, int fim) {
        System.out.print("[");
        for (int i = ini; i <= fim; i++) {
            System.out.print(v[i]);
            if (i < fim) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] nums = new int[input.length];
        for(int i = 0; i < input.length; i++) 
            nums[i] = Integer.parseInt(input[i]);
        mergeSort(nums, 0, nums.length -  1);
    }
}
