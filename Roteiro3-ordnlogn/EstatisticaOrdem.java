import java.util.*;

class EstatisticaOrdem{

    public static int estatistica(int[] v){
        int pivot = v[0];
        int i = 0;
        
        for(int j = 1; j < v.length; j++)
            if(v[j] <= pivot) swap(v, ++i, j);   
        
        swap(v, 0, i);
        return i + 1;
    }

    private static void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] v = new int[input.length];
        for(int i = 0; i < v.length; i++)
            v[i] = Integer.parseInt(input[i]);
        System.out.println(estatistica(v));
    }
}
