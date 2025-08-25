package matriz;
import java.util.Scanner;
public class atv02 {

	public static void main(String[] args) {
		
		double[] vetor = new double[10];
		
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0; i < 10; i++) {
			
			System.out.println("Digite o "+ (i+1) + "º número real: ");
			vetor [i] = scanner.nextDouble();
			
		}
		
		System.out.print("Os números na ordem decrescente são: ");
		
		for (int j = 9; j >= 0; j--) {
			
			System.out.print(vetor[j]+ " ");
			
		}
		
		
	}
}