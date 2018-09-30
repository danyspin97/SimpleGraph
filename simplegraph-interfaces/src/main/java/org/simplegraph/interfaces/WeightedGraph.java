package org.simplegraph.interfaces;

import java.util.LinkedList;

public interface WeightedGraph<V, E> {
    public boolean addVertex(V vertex);

    public boolean removeVertex(V vertex);

    public boolean containsVertex(V vertex);

    public boolean addEdge(V v1, V v2, E edge);

    public boolean removeEdge(V v1, V v2);

    public boolean existsEdge(V v1, V v2);

    public LinkedList<V> getVertices();

    public LinkedList<E> getEdges();

    public LinkedList<V> getNeighbors(V vertex);

    public int countNeighbors(V vertex);

    public int countEdges();

    public LinkedList<V> getPath(V source, V destination);

    public LinkedList<V> getShortestPath(V source, V destination);

    public E getMinimumDistance(V source, V destination);

    public WeightedGraph<V, E> getSpanningTree();

    public WeightedGraph<V, E> getMinimumSpanningTree();
}

