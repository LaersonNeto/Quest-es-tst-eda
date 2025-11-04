import java.util.*;

class MarianaLivros{

    public static void organiza(String[] v){
	imprime(v);
	for(int i = 1; i < v.length; i++){
		int j = i;
		while(j > 0 && (v[j].compareTo(v[j - 1]) < 0)){
			String aux = v[j];
			v[j] = v[j - 1];
			v[j - 1] = aux;
			j--;
		}
		imprime(v);
    	}
    }

    private static void imprime(String[] v) {
        for (int k = 0; k < v.length; k++) {
            System.out.print(v[k]);
            if (k < v.length - 1) System.out.print(", ");
        }
        System.out.println();
    }

    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	String[] v = sc.nextLine().split(",");
	if(0 < v.length && v.length < 20) organiza(v);
    }
}
