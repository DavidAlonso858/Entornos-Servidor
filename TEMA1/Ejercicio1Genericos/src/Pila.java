import java.util.LinkedList;
import java.util.List;

public class Pila<T> implements ColeccionSimpleGenerica {
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

        if (pila.size() < 0) {
            System.out.println("La lista esta vacia");
        } else {
            extraer = pila.remove(pila.size() - 1);
        }
        return extraer;
    }

    @Override
    public T primero() {

    }

    @Override
    public String toString() {
        return "Pila{" + pila + '}';
    }

    @Override
    public boolean añadir(Object e) {
        return false;
    }
}
