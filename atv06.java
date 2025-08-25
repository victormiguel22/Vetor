package matriz;
import java.util.Scanner;
public class atv06{
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] medias = new double[10];
        int alunosAprovados = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Digite as quatro notas do aluno " + (i + 1) + ":");
            double soma = 0;
            for (int j = 0; j < 4; j++) {
                System.out.print("Nota " + (j + 1) + ": ");
                soma += scanner.nextDouble();
            }
            medias[i] = soma / 4;
            if (medias[i] >= 7.0) {
                alunosAprovados++;
            }
        }

        System.out.println("Número de alunos com média maior ou igual a 7.0: " + alunosAprovados);

    }
}