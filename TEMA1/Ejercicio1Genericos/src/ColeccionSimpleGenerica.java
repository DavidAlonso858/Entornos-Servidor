import java.util.List;

public interface ColeccionSimpleGenerica<T> {
    public boolean estaVacia();

    public T extraer();

    public T primero();

    public boolean añadir(T e);
}
