package org.simplegraph;

public interface Weight<T> {
    boolean isInf();

    T getWeight();

    void setWeight(T newWeight);
}
