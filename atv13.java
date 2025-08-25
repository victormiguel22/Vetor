package matriz;
import java.util.Scanner;

public class atv13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] vetor1 = new int[10];
        int[] vetor2 = new int[10];
        int[] vetor3 = new int[20];

        System.out.println("Digite 10 números para o primeiro vetor:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Vetor1[" + i + "]: ");
            vetor1[i] = scanner.nextInt();
        }

        System.out.println("\nDigite 10 números para o segundo vetor:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Vetor2[" + i + "]: ");
            vetor2[i] = scanner.nextInt();
        }

        int j = 0; 
        for (int i = 0; i < 10; i++) {
            vetor3[j++] = vetor1[i];
            vetor3[j++] = vetor2[i];
        }

        System.out.println("\nVetor intercalado:");
        for (int i = 0; i < 20; i++) {
            System.out.print(vetor3[i] + " ");
        }

    }
}