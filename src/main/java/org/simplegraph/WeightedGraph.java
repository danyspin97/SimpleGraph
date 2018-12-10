package org.simplegraph;

import java.util.List;

public interface WeightedGraph<V> extends GraphVertices<V> {
    boolean addEdge(V v1, V v2, Double weight);

    Double getWeight(V v1, V v2);

    int countEdges();

    List<V> getShortestPath(V source, V destination);

    Double getMinimumDistance(V source, V destination);

    WeightedGraph<V> getSpanningTree();

    WeightedGraph<V> getMinimumSpanningTree();
}

