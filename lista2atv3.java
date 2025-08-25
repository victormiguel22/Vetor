package matriz;
import java.util.*;
import java.io.*;

public class lista2atv3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 0;
        String[] nomes = null;
        double[][] notas = null;
        double[] medias = null;
        double mediaGeral = 0;

        System.out.println("1. Inserir novos dados");
        System.out.println("2. Carregar do arquivo");
        int escolha = sc.nextInt();
        sc.nextLine();

        if (escolha == 1) {
            System.out.print("Digite o número de alunos (N): ");
            N = sc.nextInt();
            sc.nextLine(); 

            nomes = new String[N];
            notas = new double[N][2];

            for (int i = 0; i < N; i++) {
                System.out.print("Digite o nome do aluno " + (i + 1) + ": ");
                nomes[i] = sc.nextLine();
                System.out.print("Digite a nota 1: ");
                notas[i][0] = sc.nextDouble();
                System.out.print("Digite a nota 2: ");
                notas[i][1] = sc.nextDouble();
                sc.nextLine(); 
            }
        } else if (escolha == 2) {
            System.out.print("Digite o nome do arquivo para carregar: ");
            String nomeArquivo = sc.nextLine();
            try {
                Scanner fileSc = new Scanner(new File(nomeArquivo));
                N = fileSc.nextInt();
                fileSc.nextLine(); 

                nomes = new String[N];
                notas = new double[N][2];

                for (int i = 0; i < N; i++) {
                    nomes[i] = fileSc.nextLine();
                    String linhaNotas = fileSc.nextLine();
                    String[] partes = linhaNotas.split("\\s+");
                    notas[i][0] = Double.parseDouble(partes[0]);
                    notas[i][1] = Double.parseDouble(partes[1]);
                }
                fileSc.close();
                System.out.println("Dados carregados com sucesso do arquivo " + nomeArquivo + ".");
            } catch (Exception e) {
                System.out.println("Erro: Arquivo não encontrado ou formato inválido.");
                return;
            }
        } else {
            System.out.println("Escolha inválida.");
            return;
        }

        medias = new double[N];
        double somaTotal = 0;
        for (int i = 0; i < N; i++) {
            medias[i] = (notas[i][0] + notas[i][1]) / 2;
            somaTotal += medias[i];
        }
        mediaGeral = somaTotal / N;

        double maiorNota = Double.MIN_VALUE;
        String nomeMaiorNota = "";
        double menorNota = Double.MAX_VALUE;
        String nomeMenorNota = "";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                if (notas[i][j] > maiorNota) {
                    maiorNota = notas[i][j];
                    nomeMaiorNota = nomes[i];
                }
                if (notas[i][j] < menorNota) {
                    menorNota = notas[i][j];
                    nomeMenorNota = nomes[i];
                }
            }
        }

        double maiorMedia = Double.MIN_VALUE;
        String nomeMaiorMedia = "";
        double menorMedia = Double.MAX_VALUE;
        String nomeMenorMedia = "";
        for (int i = 0; i < N; i++) {
            if (medias[i] > maiorMedia) {
                maiorMedia = medias[i];
                nomeMaiorMedia = nomes[i];
            }
            if (medias[i] < menorMedia) {
                menorMedia = medias[i];
                nomeMenorMedia = nomes[i];
            }
        }

        System.out.println("\nNomes e notas:");
        for (int i = 0; i < N; i++) {
            System.out.println(nomes[i] + ": " + notas[i][0] + ", " + notas[i][1]);
        }

        System.out.println("\nMédias:");
        for (int i = 0; i < N; i++) {
            System.out.println(nomes[i] + ": " + medias[i]);
        }

        System.out.println("\nMaior nota: " + maiorNota + " de " + nomeMaiorNota);
        System.out.println("Menor nota: " + menorNota + " de " + nomeMenorNota);
        System.out.println("Maior média: " + maiorMedia + " de " + nomeMaiorMedia);
        System.out.println("Menor média: " + menorMedia + " de " + nomeMenorMedia);
        System.out.println("Média geral da turma: " + mediaGeral);

        System.out.println("\nAlunos acima da média geral:");
        for (int i = 0; i < N; i++) {
            if (medias[i] > mediaGeral) {
                System.out.println(nomes[i]);
            }
        }

        System.out.println("\nAlunos abaixo da média geral:");
        for (int i = 0; i < N; i++) {
            if (medias[i] < mediaGeral) {
                System.out.println(nomes[i]);
            }
        }

        System.out.print("\nDeseja salvar os dados em arquivo? (s/n): ");
        String salvarEscolha = sc.next();
        if (salvarEscolha.equalsIgnoreCase("s")) {
            System.out.print("Digite o nome do arquivo para salvar: ");
            sc.nextLine(); 
            String nomeArquivoSalvar = sc.nextLine();
            try {
                PrintWriter out = new PrintWriter(nomeArquivoSalvar);
                out.println(N);
                for (int i = 0; i < N; i++) {
                    out.println(nomes[i]);
                    out.println(notas[i][0] + " " + notas[i][1]);
                }
                out.close();
                System.out.println("Dados salvos com sucesso no arquivo " + nomeArquivoSalvar + ".");
            } catch (Exception e) {
                System.out.println("Erro ao salvar dados.");
            }
        }

    }
}