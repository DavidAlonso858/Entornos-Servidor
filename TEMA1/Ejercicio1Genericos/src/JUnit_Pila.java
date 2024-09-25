import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class JUnit_Pila {
    Pila<Integer> pila;

    @BeforeEach
    void setUp() {
        pila = new Pila<>();
    }

    @Test
    @DisplayName("Añadir")
    void testAñadirPila() {
        assert pila.añadir(6);
    }

    @Test
    @DisplayName("Pila Vacia")
    void testPilaVacia() {
        assert pila.estaVacia();
    }

    @Test
    @DisplayName("Extraer Pila")
    void testExtraerPila() {
        pila.añadir(8);
        pila.añadir(7);
        assertEquals(6, pila.extraer());
    }

    @Test
    @DisplayName("PrimeroPila")
    void testPrimeroPila() {
        assertEquals(8, pila.primero());
    }
}


