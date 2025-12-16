import java.util.Scanner;

class BuscaLinearRecursiva {
	public static int buscaLinearRecursiva(int[] vetor, int ini, int fim, int num){
		if (ini > fim) return -1;
		if (vetor[ini] == num) return ini;
		return buscaLinearRecursiva(vetor, ini + 1, fim,  num);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		int[] nums = new int[input.length];
		for (int i = 0; i < nums.length; i++)
			nums[i] = Integer.parseInt(input[i]);
		int num = sc.nextInt();
		System.out.println(buscaLinearRecursiva(nums, 0, nums.length -1, num));
	}
}
