package matriz;
import java.util.*;
import java.io.*;

public class lista2atv4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 0;
        double[][] saltos = null;
        double[] medias = null;

        System.out.println("1. Inserir novos dados");
        System.out.println("2. Carregar do arquivo");
        int escolha = sc.nextInt();
        sc.nextLine(); 

        if (escolha == 1) {
            System.out.print("Digite o número de atletas (N): ");
            N = sc.nextInt();
            sc.nextLine(); 

            saltos = new double[N][5];
            medias = new double[N];

            for (int i = 0; i < N; i++) {
                System.out.println("\nAtleta " + (i + 1) + ":");
                double soma = 0;
                double minSalto = Double.MAX_VALUE;

                for (int j = 0; j < 5; j++) {
                    System.out.print("Digite o salto " + (j + 1) + ": ");
                    saltos[i][j] = sc.nextDouble();
                    soma += saltos[i][j];
                    if (saltos[i][j] < minSalto) {
                        minSalto = saltos[i][j];
                    }
                }
                medias[i] = (soma - minSalto) / 4;
                System.out.println("Média do atleta " + (i + 1) + ": " + medias[i]);
            }
        } else if (escolha == 2) {
            System.out.print("Digite o nome do arquivo para carregar: ");
            String nomeArquivo = sc.nextLine();
            try {
                Scanner fileSc = new Scanner(new File(nomeArquivo));
                N = fileSc.nextInt();
                fileSc.nextLine();

                saltos = new double[N][5];
                medias = new double[N];

                for (int i = 0; i < N; i++) {
                    String linhaSaltos = fileSc.nextLine();
                    String[] partes = linhaSaltos.split("\\s+");
                    if (partes.length != 5) {
                        throw new Exception("Formato inválido: esperados 5 saltos.");
                    }
                    double soma = 0;
                    double minSalto = Double.MAX_VALUE;
                    for (int j = 0; j < 5; j++) {
                        saltos[i][j] = Double.parseDouble(partes[j]);
                        soma += saltos[i][j];
                        if (saltos[i][j] < minSalto) {
                            minSalto = saltos[i][j];
                        }
                    }
                    medias[i] = (soma - minSalto) / 4;
                }
                fileSc.close();
                System.out.println("Dados carregados com sucesso do arquivo " + nomeArquivo + ".");
            } catch (Exception e) {
                System.out.println("Erro: Arquivo não encontrado ou formato inválido. " + e.getMessage());
                return;
            }
        } else {
            System.out.println("Escolha inválida.");
            return;
        }


        double maiorMedia = Double.MIN_VALUE;
        double menorMedia = Double.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (medias[i] > maiorMedia) {
                maiorMedia = medias[i];
            }
            if (medias[i] < menorMedia) {
                menorMedia = medias[i];
            }
        }

        System.out.println("\nResumo dos saltos e médias:");
        for (int i = 0; i < N; i++) {
            System.out.print("Atleta " + (i + 1) + " - Saltos: ");
            for (int j = 0; j < 5; j++) {
                System.out.print(saltos[i][j] + " ");
            }
            System.out.println("- Média: " + medias[i]);
        }

        System.out.println("\nMédia do campeão: " + maiorMedia);
        System.out.println("Média do último lugar: " + menorMedia);

        System.out.print("\nDeseja salvar os dados em arquivo? (s/n): ");
        String salvarEscolha = sc.next();
        if (salvarEscolha.equalsIgnoreCase("s")) {
            System.out.print("Digite o nome do arquivo para salvar: ");
            sc.nextLine(); // Consumir nova linha
            String nomeArquivoSalvar = sc.nextLine();
            try {
                PrintWriter out = new PrintWriter(nomeArquivoSalvar);
                out.println(N);
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < 5; j++) {
                        out.print(saltos[i][j] + " ");
                    }
                    out.println();
                }
                out.close();
                System.out.println("Dados salvos com sucesso no arquivo " + nomeArquivoSalvar + ".");
            } catch (Exception e) {
                System.out.println("Erro ao salvar dados: " + e.getMessage());
            }
        }

        sc.close();
    }
}