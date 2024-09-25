import java.util.LinkedList;
import java.util.List;

public class Pila<T> implements ColeccionSimpleGenerica<T> {
    private List<T> pila;

    public Pila() {
        this.pila = new LinkedList<>();
    }

    @Override
    public boolean estaVacia() {
        return pila.isEmpty();
    }

    @Override
    public T extraer() {
        T extraer = null;

        if (pila.size() <= 0) {
            System.out.println("La lista esta vacia");
        } else {
            extraer = pila.remove(pila.size() - 1);
        }
        return extraer;
    }

    @Override
    public T primero() {
        T primero = null;

        if (pila.size() <= 0) {
            System.out.println("La lista esta vacia");
        } else {
            primero = pila.get(0);
        }
        return primero;
    }

    @Override
    public String toString() {
        return "Pila{" + pila + '}';
    }

    @Override
    public void añadir(T e) {
        pila.addFirst(e);
    }
}
