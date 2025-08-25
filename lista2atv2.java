package matriz;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
public class lista2atv2 {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        final int PRODUTOS = 5;
	        final int MERCADOS = 5;
	        double[][] precos = new double[PRODUTOS][MERCADOS];
	        boolean carregado = false;

	        System.out.print("Deseja carregar os dados de um arquivo? (s/n): ");
	        String opcao = scanner.nextLine().trim().toLowerCase();

	        if (opcao.equals("s")) {
	            try {
	                System.out.print("Digite o nome do arquivo: ");
	                String nomeArquivo = scanner.nextLine().trim();
	                Scanner fileScanner = new Scanner(new File(nomeArquivo));

	                for (int i = 0; i < PRODUTOS; i++) {
	                    for (int j = 0; j < MERCADOS; j++) {
	                        precos[i][j] = fileScanner.nextDouble();
	                    }
	                }
	                carregado = true;
	                System.out.println("Dados carregados com sucesso!");
	            } catch (Exception e) {
	                System.out.println("Erro ao carregar arquivo: " + e.getMessage());
	            }
	        }

	        if (!carregado) {
	            System.out.println("Digite os preços (produto x supermercado):");
	            for (int i = 0; i < PRODUTOS; i++) {
	                for (int j = 0; j < MERCADOS; j++) {
	                    System.out.print("Produto " + (i + 1) + " no supermercado " + (j + 1) + ": ");
	                    precos[i][j] = scanner.nextDouble();
	                }
	            }
	            scanner.nextLine(); 
	        }

	        System.out.println("\nPreços cadastrados:");
	        for (int i = 0; i < PRODUTOS; i++) {
	            System.out.print("Produto " + (i + 1) + ": ");
	            for (int j = 0; j < MERCADOS; j++) {
	                System.out.print(precos[i][j] + "\t");
	            }
	            System.out.println();
	        }

	        System.out.println("\nMédia de preço por produto:");
	        for (int i = 0; i < PRODUTOS; i++) {
	            double soma = 0;
	            for (int j = 0; j < MERCADOS; j++) {
	                soma += precos[i][j];
	            }
	            System.out.println("Produto " + (i + 1) + ": " + (soma / MERCADOS));
	        }

	        System.out.println("\nSoma de preços por supermercado:");
	        double[] somaMercados = new double[MERCADOS];
	        for (int j = 0; j < MERCADOS; j++) {
	            for (int i = 0; i < PRODUTOS; i++) {
	                somaMercados[j] += precos[i][j];
	            }
	            System.out.println("Supermercado " + (j + 1) + ": " + somaMercados[j]);
	        }

	        double menor = somaMercados[0], maior = somaMercados[0];
	        int indMenor = 0, indMaior = 0;

	        for (int j = 1; j < MERCADOS; j++) {
	            if (somaMercados[j] < menor) {
	                menor = somaMercados[j];
	                indMenor = j;
	            }
	            if (somaMercados[j] > maior) {
	                maior = somaMercados[j];
	                indMaior = j;
	            }
	        }

	        System.out.println("\nSupermercado mais barato: " + (indMenor + 1) + " (Total = " + menor + ")");
	        System.out.println("Supermercado mais caro: " + (indMaior + 1) + " (Total = " + maior + ")");

	        // ---- Gravar em arquivo ----
	        System.out.print("\nDeseja gravar os dados em arquivo? (s/n): ");
	        opcao = scanner.nextLine().trim().toLowerCase();

	        if (opcao.equals("s")) {
	            try {
	                System.out.print("Digite o nome do arquivo: ");
	                String nomeArquivo = scanner.nextLine().trim();
	                try (PrintWriter writer = new PrintWriter(new File(nomeArquivo))) {
	                    for (int i = 0; i < PRODUTOS; i++) {
	                        for (int j = 0; j < MERCADOS; j++) {
	                            writer.print(precos[i][j] + " ");
	                        }
	                        writer.println();
	                    }
	                }
	                System.out.println("Dados gravados com sucesso!");
	            } catch (Exception e) {
	                System.out.println("Erro ao gravar arquivo: " + e.getMessage());
	            }
	        }

	    }
	}