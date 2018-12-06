package org.simplegraph;

import java.util.LinkedList;

public interface DirectedWeightedGraph<V, E> extends WeightedGraph<V, E> {
    boolean isSource(V vertex, E edge);

    boolean isDestination(V vertex, E edge);

    int getInDegree(V vertex);

    int getOutDegree(V vertex);

    LinkedList<V> getInVertices(V vertex);

    LinkedList<V> getOutVertices(V vertex);

    DirectedWeightedGraph<V, E> getMinimumSpanningTree();
}

