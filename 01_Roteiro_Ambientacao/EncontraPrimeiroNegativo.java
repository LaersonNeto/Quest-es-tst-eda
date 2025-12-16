import java.util.*;

class EncontraPrimeiroNegavito{

    public static void encontra(int[] numeros){
	boolean encontrou = false;
	int saida = 0;
	for(int num: numeros){ 
		if(num < 0){ 
			encontrou = true;
			saida = num;
			break;
		}
	}
	if(encontrou) System.out.println(saida);
	else System.out.println("-");
    }

    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	String[] entrada = sc.nextLine().split(" ");
	int[] numeros = new int[entrada.length];
	for(int i = 0; i < entrada.length; i++)
		numeros[i] = Integer.parseInt(entrada[i]);
	encontra(numeros);
    }
}
