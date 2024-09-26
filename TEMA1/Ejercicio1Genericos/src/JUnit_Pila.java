import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class JUnit_Pila {
    Pila<Integer> pila;

    @BeforeEach
    void setUp() {
        // metodo que se ejcuta antes de cada test para inicializarla
        pila = new Pila<>();
    }

    @Test
    @DisplayName("Añadir")
    void testAñadirPila() {
        // verificar que se complete el ñaadir
        assertTrue(pila.añadir(6));
    }

    @Test
    @DisplayName("Pila Vacia")
    void testPilaVacia() {
        // verificar que comprueba que está vacia
        assertTrue(pila.estaVacia());

    }

    @Test
    @DisplayName("Extraer Pila")
    void testExtraerPila() {
        // añado dos y verifico si extrae el ultimo
        pila.añadir(8);
        pila.añadir(7);
        assertEquals(7, pila.extraer());
        /*
         assertEquals es una declaracion de afirmacion
         que valida que el valor esperado
         y real es el mismo, si no, se muestra un mensaje al final del metodo
         */
    }

    @Test
    @DisplayName("PrimeroPila")
    void testPrimeroPila() {
        pila.añadir(10);
        assertEquals(10, pila.primero());
    }
}


