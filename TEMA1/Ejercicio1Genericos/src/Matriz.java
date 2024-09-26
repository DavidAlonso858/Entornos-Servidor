import java.util.Arrays;

public class Matriz<T> {
    T[][] matriz;

    public Matriz(int filas, int columnas) { // constructor
        this.matriz = (T[][]) new Object[filas][columnas];
    }

    public void set(int filas, int columnas, T elemento) { // metodo para insertar el elemento en la posicion adecuada
        matriz[filas][columnas] = elemento;
    }

    public T get(int filas, int columnas) {
        T elemento = null;
        return elemento = matriz[filas-1][columnas-1];
    }

    public Integer columnas() {

        return matriz[0].length;
    }


    public Integer filas() {

        return matriz.length;
    }

    @Override
    public String toString() {
        String cadena = "";
        for (T[] fila : matriz) {
            for (T elemento : fila) {
                cadena += elemento + ", ";
            }
            cadena += "\n";
        }
        return cadena;
    }
}