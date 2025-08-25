package matriz;
import java.util.Scanner;
public class atv01 {

	public static void main(String[] args) {
		
		int[] vetor = new int[5];
		
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0; i < 5; i++) {
			
			System.out.println("Digite o " + (i+1) + "º número: ");
			vetor[i] = scanner.nextInt();
			
		}
		
		System.out.print("Os números lidos são: ");
		for (int j = 0; j < 5; j++) {
			
			System.out.print(vetor[j]+ " ");
			
		}
		
	}
}
