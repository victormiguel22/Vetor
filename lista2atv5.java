package matriz;
import java.io.*;
import java.util.*;

public class lista2atv5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do arquivo das cartelas: ");
        String nomeArquivo = sc.nextLine();

        List<int[]> cartelas = lerCartelas(nomeArquivo);
        if (cartelas.isEmpty()) {
            System.out.println("Nenhuma cartela encontrada no arquivo!");
            return;
        }

        int[] sorteio = gerarCartela();
        System.out.println("\nNúmeros sorteados: " + Arrays.toString(sorteio));

        for (int i = 0; i < cartelas.size(); i++) {
            int[] c = cartelas.get(i);
            int acertos = contarAcertos(c, sorteio);
            System.out.println("Cartela " + (i + 1) + ": " + Arrays.toString(c) + " | Acertos: " + acertos);
        }

        gravarResultados("resultados.txt", cartelas, sorteio);

        sc.close();
    }

    public static List<int[]> lerCartelas(String arquivo) {
        List<int[]> cartelas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.replaceAll("[,;]", " "); 
                String[] nums = linha.trim().split("\\s+");
                if (nums.length == 6) {
                    int[] cartela = new int[6];
                    for (int i = 0; i < 6; i++) {
                        cartela[i] = Integer.parseInt(nums[i]);
                    }
                    Arrays.sort(cartela);
                    cartelas.add(cartela);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
        return cartelas;
    }

    public static int[] gerarCartela() {
        Random rand = new Random();
        Set<Integer> numeros = new HashSet<>();
        while (numeros.size() < 6) {
            numeros.add(rand.nextInt(60) + 1);
        }
        int[] cartela = numeros.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(cartela);
        return cartela;
    }

    public static int contarAcertos(int[] cartela, int[] sorteio) {
        int acertos = 0;
        for (int n : cartela) {
            for (int s : sorteio) {
                if (n == s) acertos++;
            }
        }
        return acertos;
    }

    public static void gravarResultados(String arquivo, List<int[]> cartelas, int[] sorteio) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo))) {
            pw.println("Sorteio: " + Arrays.toString(sorteio));
            for (int i = 0; i < cartelas.size(); i++) {
                int acertos = contarAcertos(cartelas.get(i), sorteio);
                pw.println("Cartela " + (i + 1) + ": " + Arrays.toString(cartelas.get(i)) + " | Acertos: " + acertos);
            }
            System.out.println("\nResultados gravados em " + arquivo);
        } catch (IOException e) {
            System.out.println("Erro ao gravar arquivo: " + e.getMessage());
        }
    }
}