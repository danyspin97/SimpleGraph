package org.simplegraph;

import java.util.LinkedList;

public interface GraphVertices<V> {
    public boolean addVertex(V vertex);

    public boolean removeVertex(V vertex);

    public boolean containsVertex(V vertex);

    public boolean removeEdge(V v1, V v2);

    public boolean existsEdge(V v1, V v2);

    public LinkedList<V> getVertices();

    public int countVertices();

    public LinkedList<V> getNeighbors(V vertex);

    public int countNeighbors(V vertex);

    public LinkedList<V> getPath(V source, V destination);

    public boolean existsPath(V source, V destination);
}
