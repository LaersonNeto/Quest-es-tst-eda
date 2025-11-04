import java.util.*;

class SelectionSortRec {

    public static void selectionSort(int[] v, int  i){
        if(i == v.length - 1) return;
	selection(v, i);
	System.out.println(Arrays.toString(v));
    	selectionSort(v, ++i);
    }

    private static void selection(int v[], int index){
        int i_menor = index;
        for(int j = index + 1; j < v.length; j++)
                if(v[j] < v[i_menor]) i_menor = j;
        if(i_menor != index){
                int aux = v[i_menor];
                v[i_menor] = v[index];
                v[index] = aux;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] v = new int[input.length];
        for (int i = 0; i < input.length; i++)
                v[i] = Integer.parseInt(input[i]);
        selectionSort(v, 0);
    }
}
