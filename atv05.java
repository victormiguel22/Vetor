package matriz;
import java.util.Scanner;
public class atv05 {

	public static void main(String[] args) {
		
		int[] par = new int[20];
		int[] impar = new int[20];
		int[] vetor = new int[20];
		int contpar = 0, contimpar = 0;		
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0; i < 20; i++) {
			System.out.println("Digite o "+(i+1)+"º número: ");
			vetor[i] = scanner.nextInt();
			if (vetor[i]%2 == 0) {
				par[contpar] = vetor[i];
				contpar++;
			} else {
				impar[contimpar] = vetor[i];
				contimpar++;
			}
		}
		
		System.out.print("Vetor principal: ");
		for (int i = 0; i < 20; i++) { 
			System.out.print(vetor[i]+ " ");
		}
		System.out.print("\nVetor par: ");
		for (int i = 0; i < contpar; i++) { 
			System.out.print(par[i]+ " ");
		}
		System.out.print("\nVetor ímpar: ");
		for (int i = 0; i < contimpar; i++) { 
			System.out.print(impar[i]+ " ");
		}
	}		
}
