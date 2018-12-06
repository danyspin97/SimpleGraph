package org.simplegraph;

import java.util.List;

public interface DirectedWeightedGraph<V, E> extends WeightedGraph<V, E> {
    boolean isSource(V vertex, E edge);

    boolean isDestination(V vertex, E edge);

    int getInDegree(V vertex);

    int getOutDegree(V vertex);

    List<V> getInVertices(V vertex);

    List<V> getOutVertices(V vertex);

    DirectedWeightedGraph<V, E> getMinimumSpanningTree();
}

