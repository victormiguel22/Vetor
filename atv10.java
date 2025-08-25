package matriz;
import java.util.Scanner;

public class atv10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma data (dd/mm/aaaa): ");
        String data = scanner.nextLine();

        String[] partes = data.split("/");

        if (partes.length != 3) {
            System.out.println("Data inválida. Use o formato dd/mm/aaaa.");
            return;
        }

        try {
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int ano = Integer.parseInt(partes[2]);

            int[] vetorData = { dia, mes, ano };

            if (validaData(dia, mes, ano)) {
                System.out.println("Data válida");
                System.out.println("Vetor da data: [ " + vetorData[0] + ", " + vetorData[1] + ", " + vetorData[2] + " ]");
            } else {
                System.out.println("Data inválida");
            }

        } catch (NumberFormatException e) {
            System.out.println("Data inválida. Use apenas números");
        }

    }

    public static boolean validaData(int dia, int mes, int ano) {
        if (ano < 1) return false;
        if (mes < 1 || mes > 12) return false;

        int[] diasPorMes = { 31, (ehBissexto(ano) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        return dia >= 1 && dia <= diasPorMes[mes - 1];
    }

    public static boolean ehBissexto(int ano) {
        return (ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0));
    }
}
