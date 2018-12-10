package org.simplegraph;

import java.util.List;

public interface DirectedWeightedGraph<V> extends WeightedGraph<V> {
    int getInDegree(V vertex);

    int getOutDegree(V vertex);

    List<V> getInVertices(V vertex);

    List<V> getOutVertices(V vertex);

    DirectedWeightedGraph<V> getMinimumSpanningTree();
}

