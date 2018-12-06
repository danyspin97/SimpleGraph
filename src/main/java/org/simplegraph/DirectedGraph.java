package org.simplegraph;

import java.util.LinkedList;

public interface DirectedGraph<V> extends Graph<V> {
    int getInDegree(V vertex);

    int getOutDegree(V vertex);

    LinkedList<V> getInVertices(V vertex);

    LinkedList<V> getOutVertices(V vertex);
}
