import java.util.Scanner;

public class Notas {
    public double mediaNotas(double a, double b, Scanner sc) {
        double media = (a + b) / 2;
        if (media >= 5) {
            return media;
        } else {
            String recu;
            System.out.print("Cual ha sido el resultado de la recuperacion? (apto/no apto): ");
            recu = sc.next();

            switch (recu) {
                case "apto":
                    return 5;
                case "no":
                    return media;
                default:
                    System.out.println("fallo al introducir el resultado de la operacion");
                    return  media;
            }
        }
    }
}
