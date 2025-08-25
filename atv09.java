package matriz;
import java.util.Scanner;

public class atv09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um texto: ");
        String texto = scanner.nextLine();

        char[] vetor = new char[texto.length()];

        for (int i = 0; i < texto.length(); i++) {
            vetor[i] = texto.charAt(i);
        }

        System.out.println("Vetor de caracteres:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Posição " + i + ": " + vetor[i]);
        }

    }
}