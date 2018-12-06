package org.simplegraph;

import java.util.LinkedList;

public interface WeightedGraph<V, E> extends GraphVertices<V> {
    public boolean addEdge(V v1, V v2, E edge);

    public E getEdge(V v1, V v2);

    public LinkedList<E> getEdges();

    public int countEdges();

    public LinkedList<V> getShortestPath(V source, V destination);

    public E getMinimumDistance(V source, V destination);

    public WeightedGraph<V, E> getSpanningTree();

    public WeightedGraph<V, E> getMinimumSpanningTree();
}

