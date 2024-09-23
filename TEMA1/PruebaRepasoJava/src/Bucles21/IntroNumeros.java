package Bucles21;

import java.util.Scanner;

public class IntroNumeros {
    public void pedirNumeros(Scanner sc) {
        double num, impSuma = 0, resultado = 0, mayorPares = Double.MIN_VALUE;
        int contador = 0, contImpar = 0;

        do {
            System.out.print("Introduzca un numero positivo: (negativo si quiere parar) ");
            num = sc.nextDouble();

            if (num >= 0) {
                contador++;
                if (num % 2 != 0) {
                    contImpar++;
                    impSuma += num;
                    resultado = impSuma / contImpar;
                } else {
                    mayorPares = mayorPares > num ? mayorPares : num;
                }
            }
        } while (num >= 0);
        System.out.println(impSuma);
        System.out.println("El numero de numeros introducidos es " + contador);
        System.out.println("La media de los numeros impares " + String.format("%.2f", resultado));
        System.out.println("El mayor de los pares es " + mayorPares);

    }
}
