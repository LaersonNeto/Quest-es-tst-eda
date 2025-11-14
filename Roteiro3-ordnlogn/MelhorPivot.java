import java.util.*;

class MelhorPivot{
    
    public static int melhorPivot(int[] v, int i, int j){
        int media = 0;
        for(int num: v)
            media += num;
        double media_total = media/v.length; 
        if(Math.abs(v[i] - media_total) > Math.abs(v[j] - media_total)) return j;
        return i; 
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        String[] i_j = sc.nextLine().split(" ");
        int i = Integer.parseInt(i_j[0]);
        int j = Integer.parseInt(i_j[1]);
        int[] v = new int[input.length];
        for(int k = 0; k < input.length; k++)
            v[k] = Integer.parseInt(input[k]);
        System.out.println(melhorPivot(v,i,j));
    }
}
