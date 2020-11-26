package org.simplegraph;

import java.util.List;

public interface GraphVertices<V> {
    boolean addVertex(V vertex);

    boolean removeVertex(V vertex);

    boolean containsVertex(V vertex);

    boolean removeEdge(V v1, V v2);

    boolean existsEdge(V v1, V v2);

    List<V> getVertices();

    int countVertices();

    List<V> getNeighbors(V vertex);

    int countNeighbors(V vertex);

    List<V> getPath(V source, V destination);

    boolean existsPath(V source, V destination);
}
