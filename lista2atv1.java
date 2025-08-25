package matriz;
import java.util.Scanner;
import java.io.*;

public class lista2atv1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = 0;
        int[][] matriz = null;
        boolean carregado = false;

        System.out.print("Deseja carregar a matriz de um arquivo? (s/n): ");
        String opcao = scanner.nextLine().trim().toLowerCase();

        if (opcao.equals("s")) {
            try {
                System.out.print("Digite o nome do arquivo (ex: matriz.txt): ");
                String arquivo = scanner.nextLine().trim();
                Scanner fileScanner = new Scanner(new File(arquivo));
                N = fileScanner.nextInt();
                if (N < 3 || N > 11 || N % 2 == 0) {
                    System.out.println("Tamanho inválido no arquivo! Deve ser ímpar entre 3 e 11.");
                } else {
                    matriz = new int[N][N];
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            matriz[i][j] = fileScanner.nextInt();
                        }
                    }
                    carregado = true;
                    System.out.println("Matriz carregada com sucesso!");
                }
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado!");
            } catch (Exception e) {
                System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            }
        }

        if (!carregado) {
            do {
                System.out.print("Digite um valor inteiro ímpar entre 3 e 11: ");
                N = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer
            } while (N < 3 || N > 11 || N % 2 == 0);

            matriz = new int[N][N];

            System.out.println("Digite os valores da matriz:");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print("Posição [" + i + "][" + j + "]: ");
                    matriz[i][j] = scanner.nextInt();
                }
            }
            scanner.nextLine(); // Limpar buffer
        }

        int soma = 0;
        int max = matriz[0][0];
        int min = matriz[0][0];
        int contPares = 0;
        int contImpares = 0;
        int somaPrincipal = 0;
        int somaSecundaria = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                soma += matriz[i][j];
                if (matriz[i][j] > max) max = matriz[i][j];
                if (matriz[i][j] < min) min = matriz[i][j];
                if (matriz[i][j] % 2 == 0) contPares++;
                else contImpares++;
            }
            somaPrincipal += matriz[i][i];
            somaSecundaria += matriz[i][N - 1 - i];
        }

        double media = (double) soma / (N * N);
        double mediaArredondada = Math.round(media * 100.0) / 100.0;

        System.out.println("\nSoma dos elementos: " + soma);
        System.out.println("Média dos elementos: " + mediaArredondada);
        System.out.println("Maior valor: " + max);
        System.out.println("Menor valor: " + min);
        System.out.println("Contador de pares: " + contPares);
        System.out.println("Contador de ímpares: " + contImpares);
        System.out.println("Soma da diagonal principal: " + somaPrincipal);
        System.out.println("Soma da diagonal secundária: " + somaSecundaria);

        System.out.println("\nMatriz:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("\nDeseja gravar a matriz em um arquivo? (s/n): ");
        opcao = scanner.nextLine().trim().toLowerCase();

        if (opcao.equals("s")) {
            try {
                System.out.print("Digite o nome do arquivo (ex: matriz.txt): ");
                String arquivo = scanner.nextLine().trim();
                PrintWriter writer = new PrintWriter(new File(arquivo));
                writer.println(N);
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        writer.print(matriz[i][j] + " ");
                    }
                    writer.println();
                }
                writer.close();
                System.out.println("Matriz gravada com sucesso!");
            } catch (Exception e) {
                System.out.println("Erro ao gravar o arquivo: " + e.getMessage());
            }
        }

    }
}