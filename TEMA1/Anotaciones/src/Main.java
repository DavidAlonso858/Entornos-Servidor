import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Empresa em = new Empresa("DavidCEO");
        Empresa.cargadorDirectivo(em);
        Empresa.cargadorTecnico(em);
        Empresa.cargadorOficial(em);
        System.out.println(em);
    }
}