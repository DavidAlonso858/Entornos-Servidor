package Condicionales21;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b;

        System.out.print("Nota del primer control: ");
        a = sc.nextDouble();

        System.out.print("Nota del segundo control: ");
        b = sc.nextDouble();

        Notas n1 = new Notas();

        System.out.println(n1.mediaNotas(a, b, sc));
    }
}
