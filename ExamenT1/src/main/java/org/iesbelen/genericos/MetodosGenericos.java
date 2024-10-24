package org.iesbelen.genericos;

import java.util.Set;

public interface MetodosGenericos<T> {
    public boolean add(T e);

    public boolean add(T e, Integer n);

    public Integer getcount(T e);

    public boolean remove(T e);

    public boolean remove(T e, Integer n);

    public Integer size();

    public Set<T> uniqueSet();
}

