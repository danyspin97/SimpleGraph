package org.simplegraph;

import java.util.List;

/**
 Interface for weighted graphs.
 */
public interface WeightedGraph<V> extends GraphVertices<V> {
    /**
     * Add an edge between two vertices.
     * Add the two vertices in the graph if they don't exists
     * @param  v1 first vertex
     * @param  v2 second vertex
     * @return    true if the graph has been modified
     */
    boolean addEdge(V v1, V v2, Double weight);

    /**
     * Get the edge between two vertices
     * @param  v1   first vertex
     * @param  v2   second vertex
     * @return      the edge between v1 and v2, if it exists, null otherwise
     */
    Double getWeight(V v1, V v2);

    /**
     * Get the number of edges in the graph.
     * @return number of edges
     */
    int countEdges();

    List<V> getShortestPath(V source, V destination);

    Double getMinimumDistance(V source, V destination);

    WeightedGraph<V> getSpanningTree();

    WeightedGraph<V> getMinimumSpanningTree();
}

