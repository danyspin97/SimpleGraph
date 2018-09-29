package org.simplegraph.interfaces;

import java.util.Collection;

public interface Graph<V> {
    public boolean addVertex(V vertex);

    public boolean removeVertex(V vertex);

    public boolean containsVertex(V vertex);

    public boolean addEdge(V v1, V v2);

    public boolean removeEdge(V v1, V v2);

    public boolean existsEdge(V v1, V v2);

    public Collection<V> getNeighbors(V vertex);

    public int countNeighbors(V vertex);

    public int countEdges();

    public Collection<V> getPath(V source, V destination);

    public Graph<V> getSpanningTree();
}

