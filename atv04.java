package matriz;
import java.util.Scanner;
public class atv04 {

	public static void main(String[] args) {
		
		String[] vetor = new String[10];
		String[] consoantes = new String[10];
		int  cont = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Digite a "+(i+1)+"ª letra: ");
			vetor[i] = scanner.nextLine();
			if (!(vetor[i].equals("a")) && !(vetor[i].equals("e")) && !(vetor[i].equals("i"))
					&& !(vetor[i].equals("o")) && !(vetor[i].equals("u"))){
				consoantes[cont] = vetor[i];
				cont++;
					
			}
		}
		
		System.out.print("As "+cont+" consoantes lidas foram: ");
		for (int j = 0; j < cont; j++) {
			System.out.print(consoantes[j]+ " ");
		}
	}
}