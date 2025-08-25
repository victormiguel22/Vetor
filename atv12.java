package matriz;
import java.util.Scanner;

public class atv12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] idades = new int[5];
        double[] alturas = new double[5];
        
        for (int i = 0; i < 5; i++) {
            System.out.println("Digite a idade da pessoa " + (i + 1) + ":");
            idades[i] = scanner.nextInt();
            System.out.println("Digite a altura (em metros) da pessoa " + (i + 1) + ":");
            alturas[i] = scanner.nextDouble();
        }
        
        System.out.println("\nIdades e alturas na ordem inversa:");
        for (int i = 4; i >= 0; i--) {
            double alturaArredondada = Math.round(alturas[i] * 100.0) / 100.0;
            System.out.println("Pessoa " + (5 - i) + ": Idade = " + idades[i] + ", Altura = " + alturaArredondada + " m");
        }
        
        int maisVelho = idades[0], maisNovo = idades[0];
        double maisAlto = alturas[0], maisBaixo = alturas[0];
        int idxMaisVelho = 0, idxMaisNovo = 0, idxMaisAlto = 0, idxMaisBaixo = 0;
        
        for (int i = 1; i < 5; i++) {
            if (idades[i] > maisVelho) {
                maisVelho = idades[i];
                idxMaisVelho = i;
            }
            if (idades[i] < maisNovo) {
                maisNovo = idades[i];
                idxMaisNovo = i;
            }
            if (alturas[i] > maisAlto) {
                maisAlto = alturas[i];
                idxMaisAlto = i;
            }
            if (alturas[i] < maisBaixo) {
                maisBaixo = alturas[i];
                idxMaisBaixo = i;
            }
        }
        
        System.out.println("\nMais velho: Idade = " + maisVelho + ", Altura = " + (Math.round(alturas[idxMaisVelho] * 100.0) / 100.0) + " m");
        System.out.println("Mais novo: Idade = " + maisNovo + ", Altura = " + (Math.round(alturas[idxMaisNovo] * 100.0) / 100.0) + " m");
        System.out.println("Mais alto: Altura = " + (Math.round(maisAlto * 100.0) / 100.0) + " m, Idade = " + idades[idxMaisAlto]);
        System.out.println("Mais baixo: Altura = " + (Math.round(maisBaixo * 100.0) / 100.0) + " m, Idade = " + idades[idxMaisBaixo]);
        
        double somaIdades = 0, somaAlturas = 0;
        for (int i = 0; i < 5; i++) {
            somaIdades += idades[i];
            somaAlturas += alturas[i];
        }
        double mediaIdade = somaIdades / 5;
        double mediaAltura = somaAlturas / 5;
        
        System.out.println("\nMédia de idade: " + (Math.round(mediaIdade * 100.0) / 100.0) + " anos");
        System.out.println("Média de altura: " + (Math.round(mediaAltura * 100.0) / 100.0) + " m");
        
        System.out.println("\nPessoas com idade acima da média:");
        for (int i = 0; i < 5; i++) {
            if (idades[i] > mediaIdade) {
                System.out.println("Pessoa " + (i + 1) + ": Idade = " + idades[i] + ", Altura = " + (Math.round(alturas[i] * 100.0) / 100.0) + " m");
            }
        }
        System.out.println("\nPessoas com idade abaixo da média:");
        for (int i = 0; i < 5; i++) {
            if (idades[i] < mediaIdade) {
                System.out.println("Pessoa " + (i + 1) + ": Idade = " + idades[i] + ", Altura = " + (Math.round(alturas[i] * 100.0) / 100.0) + " m");
            }
        }
        
        System.out.println("\nPessoas com altura acima da média:");
        for (int i = 0; i < 5; i++) {
            if (alturas[i] > mediaAltura) {
                System.out.println("Pessoa " + (i + 1) + ": Idade = " + idades[i] + ", Altura = " + (Math.round(alturas[i] * 100.0) / 100.0) + " m");
            }
        }
        System.out.println("\nPessoas com altura abaixo da média:");
        for (int i = 0; i < 5; i++) {
            if (alturas[i] < mediaAltura) {
                System.out.println("Pessoa " + (i + 1) + ": Idade = " + idades[i] + ", Altura = " + (Math.round(alturas[i] * 100.0) / 100.0) + " m");
            }
        }
        
    }
}