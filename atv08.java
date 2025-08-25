package matriz;
import java.util.Random;
import java.util.Scanner;

public class atv08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] alfabeto = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
                          'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] vogais = {'a', 'e', 'i', 'o', 'u'};
        char[] consoantes = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 
                            'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
        
        Random random = new Random();

        System.out.print("Digite o tamanho da senha desejada (menor que 26): ");
        int tamanho = scanner.nextInt();

        if (tamanho >= 26 || tamanho < 1) {
            System.out.println("Tamanho inválido! Deve ser menor que 26 e maior que 0.");
            return;
        }

        StringBuilder senha = new StringBuilder();
        boolean par = tamanho % 2 == 0;

        for (int i = 0; i < tamanho; i++) {
            if (par || i < tamanho - 1) {
                if (i % 2 == 0) {
                    senha.append(consoantes[random.nextInt(consoantes.length)]);
                } else {
                    senha.append(vogais[random.nextInt(vogais.length)]);
                }
            } else {
                senha.append(consoantes[random.nextInt(consoantes.length)]);
            }
        }

        System.out.println("Senha gerada: " + senha.toString());
        scanner.close();
    }
}