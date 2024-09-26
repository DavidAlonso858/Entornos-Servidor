
import java.util.Collections;
import java.util.LinkedList;

public class ListaOrdenada<E extends Comparable<E>> {
    private LinkedList<E> lista;

    public ListaOrdenada() {
        lista = new LinkedList<>();
    }

    public void add(E o) {

        lista.add(o);
        Collections.sort(lista); // lista se ordena con el Comparable
    }

    public E get(int index) {
        if (index >= 0 && index <= lista.size()) {
            return lista.get(index);
        }
        throw new IndexOutOfBoundsException("Indice fuera de rango");
    }

    public int size() {
        return lista.size();
    }

    public boolean isEmpty() {
        return lista.isEmpty();
    }

    public boolean remove(E o) {
        return lista.remove(o);
    }

    public int indexOf(E o) {
        return lista.indexOf(o);
    }

    public String toString() {
        return lista.toString();
    }
}
