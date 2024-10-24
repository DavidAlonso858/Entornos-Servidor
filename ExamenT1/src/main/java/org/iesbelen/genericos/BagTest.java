package org.iesbelen.genericos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BagTest {
    Bag<Integer> bolsa;

    @BeforeEach
        // Test que la inicia cada vez que hacemos una comprobacion
    void setUp() {
        bolsa = new Bag<>();
    }

    @Test
    @DisplayName("Añadir")
        // test que valida que se añaden elementos
    void testAddBolsa() {
        Assertions.assertTrue(bolsa.add(1));
    }

    @Test
    @DisplayName("Añadir Todos")
        // test que valida que se añaden los elementos
    void testAddTodosBolsa() {
        Assertions.assertTrue(bolsa.add(2, 3));
    }

    @Test
    @DisplayName("Contador")
        // test que valida el contador de un elemento
    void testContadorBolsa() {
        bolsa.add(5, 2);

        Assertions.assertEquals(2, bolsa.getcount(5));
    }

    @Test
    @DisplayName("Eliminar")
        // test que valida el eliminar el elemento pasado
    void testEliminarBolsa() {
        bolsa.add(7);

        Assertions.assertTrue(bolsa.remove(7));
    }

    @Test
    @DisplayName("Eliminar varios")
        // test que valida la eliminacion de los elementos
    void testEliminarVarios() {
        bolsa.add(8, 3);

        Assertions.assertTrue(bolsa.remove(8, 3));
    }

    @Test
    @DisplayName("Tamaño de la Coleccion")
        // test que validad la devolucion del tamaño de la coleccion
    void testTamañoBolsa() {
        bolsa.add(8);
        bolsa.add(9);
        bolsa.add(10);
        bolsa.add(11);

        Assertions.assertEquals(4, bolsa.size());
    }

    @Test
    @DisplayName("Set existe")
    void testSetExisteBolsa() { // verifico que se crea el set comparandolo con otro
        // set que yo creo a mano con los mismo elementos
        // (un set no repite elementos por eso le pongo dos 8 a cada unoo
        bolsa.add(8);
        bolsa.add(4);
        bolsa.add(3);
        bolsa.add(8);

        Set<Integer> resultado = bolsa.uniqueSet();

        Set<Integer> esperado = new LinkedHashSet<>();
        esperado.add(8);
        esperado.add(4);
        esperado.add(3);
        esperado.add(8);

        Assertions.assertEquals(esperado, resultado);
    }
}
