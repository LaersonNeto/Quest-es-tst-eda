import java.util.*;

class InserePrimeiro {

    public static int[] inserePrimeiro(int[] v){
        int i = 0;
        while (i < v.length - 1 && v[i] > v[i + 1]){
                int aux = v[i];
                v[i] = v[i + 1];
                v[i + 1] = aux;
                i++;
        }
        return v;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int[] v = new int[entrada.length];
        for(int i = 0; i < entrada.length; i++)
                v[i] = Integer.parseInt(entrada[i]);
        System.out.println(Arrays.toString(inserePrimeiro(v)));
    }
}
