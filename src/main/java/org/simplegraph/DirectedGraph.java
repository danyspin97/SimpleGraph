package org.simplegraph;

import java.util.List;

public interface DirectedGraph<V> extends Graph<V> {
    int getInDegree(V vertex);

    int getOutDegree(V vertex);

    List<V> getInVertices(V vertex);

    List<V> getOutVertices(V vertex);
}
