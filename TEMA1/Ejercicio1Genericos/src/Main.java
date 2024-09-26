public class Main {
    public static void main(String[] args) {
        Integer contador = 0;

        Matriz m1 = new Matriz(4, 2);
        for (int i = 0; i < m1.filas(); i++) {
            for (int j = 0; j < m1.columnas(); j++) {
                m1.set(i, j, contador++);
            }
        }

        System.out.println(m1);
        System.out.println("El numero de la fila 1, columna 2 es: " + m1.get(1, 2));
    }
}