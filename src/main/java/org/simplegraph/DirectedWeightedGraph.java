package org.simplegraph;

import java.util.LinkedList;

public interface DirectedWeightedGraph<V, E> extends WeightedGraph<V, E> {
    public boolean isSource(V vertex, E edge);

    public boolean isDestination(V vertex, E edge);

    public int getInDegree(V vertex);

    public int getOutDegree(V vertex);

    public LinkedList<V> getInVertices(V vertex);

    public LinkedList<V> getOutVertices(V vertex);

    public DirectedWeightedGraph<V, E> getMinimumSpanningTree();
}

