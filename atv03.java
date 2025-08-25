package matriz;
import java.util.Scanner;
public class atv03 {

	public static void main(String[] args) {
		
		double[] vetor = new double[4];
		double media = 0;
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0; i < 4; i++) {
			
			System.out.println("Digite a "+ (i+1) + "ª nota: ");
			vetor [i] = scanner.nextDouble();
			
		}
		
		System.out.print("As notas são: ");
		
		for (int j = 0; j < 4; j++) {
			media = media + vetor[j];
			System.out.print(vetor[j]+ " ");
		}
		
		System.out.println("A média é: "+ (media/4) );
		
	}
}