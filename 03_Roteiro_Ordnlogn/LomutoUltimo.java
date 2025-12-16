import java.util.*;

class LomutoUltimo{

    public static int lomuto(int[] v){
        int pivot = v[v.length - 1];
        int i = v.length - 1;
        
        for(int j = v.length - 2; j >= 0; j--){
            if(v[j] > pivot){
                i--;
                int aux = v[j];
                v[j] = v[i];
                v[i] = aux;
                System.out.println(Arrays.toString(v));
            }
        }
        int aux = pivot;
        v[v.length - 1] = v[i];
        v[i] = aux;
        System.out.println(Arrays.toString(v));
        System.out.println(Arrays.toString(v));
        return i;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] v = new int[input.length];
        for(int i = 0; i < input.length; i++)
            v[i] = Integer.parseInt(input[i]);
        lomuto(v);
    }

}
