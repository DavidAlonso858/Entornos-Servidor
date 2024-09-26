import java.util.Arrays;

public class PilaArray<T> implements ColeccionSimpleGenerica<T> {
    private T pila[];
    private int contador;

    public PilaArray(int i) {
        contador = 0;
        this.pila = (T[]) new Object[contador];
    }

    @Override
    public boolean estaVacia() {
        boolean vacio = false;
        if (contador == 0) {
            vacio = true;
        }

        return vacio;
    }

    @Override
    public T extraer() {
        T extraer = null;

        if (pila.length <= 0) {
            System.out.println("La lista esta vacia");
        } else {
            extraer = pila[pila.length - 1];
            pila = Arrays.copyOf(pila, pila.length - 1);
            contador--;
        }
        return extraer;
    }

    @Override
    public T primero() {
        T primero = null;
        if (pila.length <= 0) {
            System.out.println("La lista esta vacia");
        } else {
            primero = pila[0];
        }
        return primero;
    }


    @Override
    public boolean añadir(T e) {

        pila = Arrays.copyOf(pila, pila.length + 1);
        pila[pila.length - 1] = e;
        contador++;
        return pila[pila.length - 1] == e;
    }

    @Override
    public String toString() {
        return "PilaArray{" + Arrays.toString(pila) +
                ", contador=" + contador +
                '}';
    }
}
