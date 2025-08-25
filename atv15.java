package matriz;
import java.util.Scanner;

public class atv15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int N;

        System.out.print("Digite o tamanho do vetor: ");
        N = scanner.nextInt();

        if (N <= 0) {
            System.out.println("Tamanho inválido! Deve ser maior que 0.");
            scanner.close();
            return;
        }

        int[] valores = new int[N];

        for (int i = 0; i < N; i++) {
            System.out.print("Digite o valor " + (i + 1) + " (entre 0 e 20): ");
            int valor = scanner.nextInt();
            while (valor < 0 || valor > 20) {
                System.out.print("Valor inválido! Digite novamente (entre 0 e 20): ");
                valor = scanner.nextInt();
            }
            valores[i] = valor;
        }

        System.out.println("\nGráfico:");
        for (int i = 0; i < N; i++) {
            System.out.print(valores[i] + ": ");
            for (int j = 0; j < valores[i]; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

    }
}