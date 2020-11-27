package org.simplegraph;

import java.util.List;

/**
 Interface for directed and weighted graphs.
 */
public interface DirectedWeightedGraph<V> extends WeightedGraph<V> {
    /**
     * Get the number of incident vertices of a vertex.
     * @param  vertex the specified vertex
     * @return        the number of incident vertices of vertex, -1 if vertex
     *                is not contained in the graph
     */
    int getInDegree(V vertex);

    /**
     * Get the number of outer vertices of a vertex.
     * @param  vertex the specified vertex
     * @return        the number of outer vertices of vertex, -1 if vertex
     *                is not contained in the graph
     */
    int getOutDegree(V vertex);

    /**
     * Get the incident vertices of a vertex.
     * @param  vertex the specified vertex
     * @return        a list containing the incident vertices of vertex,
     *                null if vertex is not contained in the graph
     */
    List<V> getInVertices(V vertex);

    /**
     * Get the outer vertices of a vertex.
     * @param  vertex the specified vertex
     * @return        a list containing the outer vertices of vertex,
     *                null if vertex is not contained in the graph
     */
    List<V> getOutVertices(V vertex);

    DirectedWeightedGraph<V> getMinimumSpanningTree();
}

