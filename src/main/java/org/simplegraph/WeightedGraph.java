package org.simplegraph;

import java.util.List;

public interface WeightedGraph<V, E> extends GraphVertices<V> {
    boolean addEdge(V v1, V v2, E edge);

    E getEdge(V v1, V v2);

    List<E> getEdges();

    int countEdges();

    List<V> getShortestPath(V source, V destination);

    E getMinimumDistance(V source, V destination);

    WeightedGraph<V, E> getSpanningTree();

    WeightedGraph<V, E> getMinimumSpanningTree();
}

