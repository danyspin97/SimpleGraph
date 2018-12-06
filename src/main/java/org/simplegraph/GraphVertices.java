package org.simplegraph;

import java.util.LinkedList;

public interface GraphVertices<V> {
    boolean addVertex(V vertex);

    boolean removeVertex(V vertex);

    boolean containsVertex(V vertex);

    boolean removeEdge(V v1, V v2);

    boolean existsEdge(V v1, V v2);

    LinkedList<V> getVertices();

    int countVertices();

    LinkedList<V> getNeighbors(V vertex);

    int countNeighbors(V vertex);

    LinkedList<V> getPath(V source, V destination);

    boolean existsPath(V source, V destination);
}
