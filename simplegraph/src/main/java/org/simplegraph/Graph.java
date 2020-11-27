package org.simplegraph;

/**
 Interface for graphs.
 */
public interface Graph<V> extends GraphVertices<V> {
    /**
     * Add an edge between two vertices.
     * Add the two vertices in the graph if they don't exists
     * @param  v1 first vertex
     * @param  v2 second vertex
     * @return    true if the graph has been modified
     */
    boolean addEdge(V v1, V v2);

    /**
     * Get the number of edges in the graph.
     * @return number of edges
     */
    int countEdges();

    Graph<V> getSpanningTree();
}

