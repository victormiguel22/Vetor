package matriz;
import java.util.Scanner;

public class atv07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numeros = new int[5];
        int soma = 0;
        int multiplicacao = 1;

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();

            soma += numeros[i];        
            multiplicacao *= numeros[i];  
        }

        System.out.print("Números digitados: ");
        for (int num : numeros) {
            System.out.print(num + " ");
        }

        System.out.println("\nSoma = " + soma);
        System.out.println("Multiplicação = " + multiplicacao);

    }
}