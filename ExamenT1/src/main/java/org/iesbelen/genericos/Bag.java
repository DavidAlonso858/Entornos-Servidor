package org.iesbelen.genericos;

import java.util.*;

public class Bag<T> implements MetodosGenericos<T> {
    private Collection<T> bolsa;

    public Bag() {
        this.bolsa = new LinkedList<>();
    }

    @Override
    public boolean add(T e) {
        return bolsa.add(e);
    }

    @Override
    public boolean add(T e, Integer n) {

        for (int i = 0; i < n; i++) {
            bolsa.add(e);
        }
        return bolsa.contains(e);
    }


    @Override
    public Integer getcount(T e) {
        Integer contador = 0;
        for (int i = 0; i < bolsa.size(); i++) {
            if (bolsa.contains(e)) {
                contador++;
            }
        }
        return contador;
    }

    @Override
    public boolean remove(T e) {
        return bolsa.remove(e);
    }

    @Override
    public boolean remove(T e, Integer n) {
        for (int i = 0; i < n; i++) {
            bolsa.remove(e);
        }
        return !bolsa.contains(e);
    }

    @Override
    public Integer size() {
        return bolsa.size();
    }


    @Override
    public Set<T> uniqueSet() {
        Set<T> setBolsa = new LinkedHashSet<>(bolsa);
        return setBolsa;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "bolsa=" + bolsa +
                '}';
    }
}
