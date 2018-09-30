package org.simplegraph.interfaces;

import java.util.LinkedList;

public interface DirectedWeightedGraph<V, E> extends WeightedGraph<V, E>, DirectedGraph<V> {
    public boolean isSource(V vertex, E edge);
    
    public boolean isDestination(V vertex, E edge);
}
