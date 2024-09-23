package Condicionales23;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double baseImponible, costoIVA, total = 0;
        String tipoIva, codigoPromo;

        System.out.print("Introduzca la base imponible: ");
        baseImponible = sc.nextDouble();

        System.out.print("Introduzca el tipo de IVA (general, reducido o superreducido: ");
        tipoIva = sc.next();

        System.out.print("Introduzca el codigo de promocional (nopro, mitad, meno5 o 5porc): ");
        codigoPromo = sc.next();

        System.out.println("Base imponible\t " + baseImponible);
        switch (tipoIva) {
            case "general":
                costoIVA = baseImponible * 0.21;
                System.out.println("IVA (21%)\t" + costoIVA); // el iva
                total = baseImponible + costoIVA;
                System.out.println("Precio con IVA\t" + total);
                break;
            case "reducido":
                costoIVA = baseImponible * 0.10;
                System.out.println("IVA (10%)\t" + costoIVA); // el iva
                total = baseImponible + costoIVA;
                System.out.println("Precio con IVA\t" + total);
                break;
            case "superreducido":
                costoIVA = baseImponible * 0.05;
                System.out.println("IVA (4%)\t" + costoIVA); // el iva
                total = baseImponible + costoIVA;
                System.out.println("Precio con IVA\t" + total);
                break;
            default:
                System.out.println("fallo al introducir el iva");
        }
        switch (codigoPromo) {
            case "nopro":
                System.out.println("Cod.promo (nopro)\t): ");
                System.out.println("TOTAL\t" + total);
                break;
            case "mitad":
                System.out.println("Cod.promo (mitad)): -" + (total / 2));
                System.out.println("TOTAL\t" + (total / 2));
                break;
            case "meno5":
                System.out.println("Cod.promo (mitad)): -5");
                System.out.println("TOTAL\t" + (total - 5));
                break;
        }
    }
}
