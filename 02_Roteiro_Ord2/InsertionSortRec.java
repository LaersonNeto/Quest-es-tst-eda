import java.util.*;

class InsertionSortRec{
	
    public static void insertSort(int[] v, int index){
	if(index >= v.length) return;
	int i = index;
	while(i > 0 && v[i] < v[i - 1]){
		int aux = v[i];
		v[i] = v[i - 1];
		v[i - 1] = aux;
		i--;
	}
	System.out.println(Arrays.toString(v));
	insertSort(v, ++index);
    }

    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	String[] entrada = sc.nextLine().split(" ");
	int[] v = new int[entrada.length];
	for(int i = 0; i < entrada.length; i++)
		v[i] = Integer.parseInt(entrada[i]);
	insertSort(v, 1);
    }
}
