package org.simplegraph;

import java.util.List;

interface GraphVertices<V> {
    /**
     * Add a vertex to the graph.
     * @param  vertex the vertex to add
     * @return        true if the the graph has been modified
     */
    boolean addVertex(V vertex);

    /**
     * Remove a vertex from the graph
     * @param  vertex the vertex to remove
     * @return        true if the graph has been modified
     */
    boolean removeVertex(V vertex);

    /**
     * Check the existence of a vertex in the graph.
     * @param  vertex the vertex to check
     * @return        true if the graph contains vertex
     */
    boolean containsVertex(V vertex);

    /**
     * Remove an edge that goes from the first vertex to the second.
     * @param  v1 first vertex
     * @param  v2 second vertex
     * @return    true if the graph has been changed
     */
    boolean removeEdge(V v1, V v2);

    /**
     * Check the existence of an edge that goes from the first vertex to the second.
     * @param  v1 first vertex
     * @param  v2 second vertex
     * @return    true if an edge from v1 to v2 exists
     */
    boolean existsEdge(V v1, V v2);

    /**
     * Get all the vertices in the graph
     * @return a list containing all the graph vertices
     */
    List<V> getVertices();

    /**
     * Get the number of vertices in the graph.
     * @return number of vertices
     */
    int countVertices();

    /**
     * Get the neighbors of a vertex
     * @param  vertex the specified vertex
     * @return        the list of vertices that are neighbors of vertex
     *                null if the vertex is not contained in the graph
     */
    List<V> getNeighbors(V vertex);

    /**
     * Get the number of neighbors for a vertex.
     * @param  vertex the spefied vertex
     * @return        number of neighbors, -1 if vertex does not exists
     */
    int countNeighbors(V vertex);

    /**
     * Get a path between a source and a destination
     * @param source      source vertex
     * @param destination destination vertex
     * @return            a list containing the vertices that
     *                    compose the path, in order; an empty LinkedList if
     *                    there is no path, null if the source and the
     *                    destination are equals or are not contained in the
     *                    graph
     */
    List<V> getPath(V source, V destination);

    /**
     * Does a path exists between source and destination.
     * @param source      source vertex
     * @param destination destination vertex
     * @return            true if a path exists
     */
    boolean existsPath(V source, V destination);
}
