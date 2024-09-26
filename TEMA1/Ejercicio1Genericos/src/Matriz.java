import java.util.Arrays;

public class Matriz<T> {
    T[][] matriz;

    public Matriz(int columnas, int filas) { // constructor
        this.matriz = (T[][]) new Object[columnas][filas];
    }

    public void set(int columnas, int filas, T elemento) { // metodo para insertar el elemento en la posicion adecuada
        matriz[columnas][filas] = elemento;
    }

    public T get(int filas, int columnas) {
        T elemento = null;
        return elemento = matriz[columnas][filas];
    }

    public Integer columnas() {

        return matriz[0].length;
    }


    public Integer filas() {

        return matriz.length;
    }

    @Override
    public String toString() {
        return "Matriz{" + Arrays.toString(matriz) +
                '}';
    }
}
