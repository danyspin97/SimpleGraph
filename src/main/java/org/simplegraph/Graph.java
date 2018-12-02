package org.simplegraph;

import java.util.LinkedList;

public interface Graph<V> extends GraphVertices<V> {
    public boolean addEdge(V v1, V v2);

    public int countEdges();

    public Graph<V> getSpanningTree();
}

