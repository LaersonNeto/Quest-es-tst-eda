import java.util.*;

class QuebraRec{

    public static void quebra(int[] v, int i){
	if(i >= v.length){
		System.out.println(-1);
		return;
	}
	if(v[i] < v[i-1]) {
		System.out.println(i);
		return;
	}
	quebra(v, ++i);
    }

    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
	String[] entrada = sc.nextLine().split(" ");
	int[] v = new int[entrada.length];
	for(int i = 0; i < v.length; i++)
		v[i] = Integer.parseInt(entrada[i]);
	quebra(v, 1);
    }
}
