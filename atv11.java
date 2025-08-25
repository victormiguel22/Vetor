package matriz;
import java.util.Scanner;

public class atv11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite as palavras separadas por ';': ");
        String entrada = scanner.nextLine();
        
        String[] palavras = entrada.split(";");
        
        System.out.println("Palavras separadas:");
        for (int i = 0; i < palavras.length; i++) {
            System.out.println("Posição " + i + ": " + palavras[i]);
        }
        
    }
}