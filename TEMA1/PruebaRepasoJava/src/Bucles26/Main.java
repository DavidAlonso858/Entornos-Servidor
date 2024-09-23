package Bucles26;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num, digito, longitud = 1;
        boolean encontrado = false;

        System.out.print("Introduce numero: ");
        num = sc.nextInt();
        System.out.print("Introduce digito: ");
        digito = sc.nextInt();

        int aux = num; // para luego trabajar con el num
        while (aux > 9) {
            longitud++;
            aux /= 10;
        }

        for (int i = longitud; i > 0 && !encontrado; i--) { // sale cuando lo encuentra
            int dig = num % 10; // pilla digito a digito
            if (digito == dig) {
                System.out.println("La posicion de ese digito es " + i);
                encontrado = true;
            }
            num /= 10; // ir reduciendo
        }
    }
}
