package org.simplegraph.impl.base;

import java.util.LinkedList;

import org.simplegraph.DirectedGraph;

public class BaseDirectedDenseGraph<V, E> extends BaseDenseGraph<V> {
    protected E[][] edges;

    /**
     * Copy constructor
     * @param graph graph to copy
     */
    @SuppressWarnings("unchecked")
    protected void copy(BaseDirectedDenseGraph<V,E> graph) {
        initialize(graph.size);

        copyVertices(graph);

        edges = (E[][]) new Object [size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                edges[i][j] = graph.edges[i][j];
            }
        }
    }

    /**
     * Initialize all attributes for storing graph data.
     * @param startSize Number of vertices to store initially in the graph.
     */
    @SuppressWarnings("unchecked")
    protected void initialize(int startSize) {
        super.initialize(startSize);

        edges = (E[][]) new Object[startSize][startSize];

        for (int i = 0; i != size; ++i) {
            for (int j = 0; j != size; j++) {
                edges[i][j] = null;
            }
        }
    }

    /**
     * Grow the graph size to the specified size
     * @param newSize New size for the graph.
     */
    @SuppressWarnings("unchecked")
    public void grow(int newSize) {
        int oldSize = size;
        super.grow(newSize);

        E[][] newMatrix = (E[][]) new Object[size][size];
        for (int i = 0; i != oldSize; ++i) {
            for (int j = 0; j != oldSize; j++) {
                newMatrix[i][j] = edges[i][j];
            }
        }

        for (int i = oldSize; i != size; ++i) {
            for (int j = oldSize; j != size; j++) {
                newMatrix[i][j] = null;
            }
        }
        edges = newMatrix;
    }

    /**
     * Remove a vertex from the graph
     * @param  vertex the vertex to remove
     * @return        true if the graph has been modified
     */
    public boolean removeVertex(V vertex)
    {
        int oldVertex = getVertexIndex(vertex);
        if (!super.removeVertex(vertex)) {
            return false;
        }

        // For each vertex, except the one to swap
        // verticesCount has been already decremented in super.removeVertex()
        for (int i = 0; i != verticesCount; i++) {
            // Swap the edges of the last vertex (with index verticesCount)
            // with the edges of the vertex to remove (index i)
            // remove both a,b and b,a
            edges[oldVertex][i] = edges[verticesCount][i];
            edges[verticesCount][i] = null;

            edges[i][oldVertex] = edges[i][verticesCount];
            edges[i][verticesCount] = null;
        }

        return true;
    }

    /**
     * Add an edge that goes from the first vertex to the second.
     * Add the two vertices in the graph if they don't exists.
     * @param  v1   first vertex
     * @param  v2   second vertex
     * @param  edge edge to add
     * @return      true if the graph has been modified
     */
    public boolean _addEdge(V v1, V v2, E edge) {
        // Null is not a valid value
        if (v1 == null || v2 == null || edge == null) {
            return false;
        }

        int i1 = getVertexIndex(v1);
        int i2 = getVertexIndex(v2);

        if (i1 == -1) {
            addVertex(v1);
        }

        if (i2 == -1) {
            addVertex(v2);
        }

        if (i1 == i2) {
            return false;
        }

        // get last value to check if the graph has been modified
        E t = edges[i1][i2];
        edges[i1][i2] = edge;
        return t == null || !edge.equals(t);
    }

    /**
     * Remove an edge that goes from the first vertex to the second.
     * @param  v1 first vertex
     * @param  v2 second vertex
     * @return    true if an edge from v1 to v2 exists
     */
    public boolean removeEdge(V v1, V v2)
    {
        int i1 = getVertexIndex(v1);
        int i2 = getVertexIndex(v2);

        if (i1 == -1 || i2 == -1) {
            return false;
        }

        if (i1 == i2) {
            return false;
        }

        E t =  edges[i1][i2];
        edges[i1][i2] = null;
        return t != null;
    }

    /**
     * Check the existence of an edge that goes from the first vertex to the second.
     * @param  v1 first vertex
     * @param  v2 second vertex
     * @return    true if an edge from v1 to v2 exists
     */
    public boolean existsEdge(V v1, V v2) {
        int i1 = getVertexIndex(v1);
        int i2 = getVertexIndex(v2);

        if (i1 == -1 || i2 == -1) {
            return false;
        }

        if (i1 == i2) {
            return false;
        }

        return edges[i1][i2] != null;
    }

    /**
     * Get the neighbors of a vertex, both incident and outer vertices.
     * @param  vertex the specified vertex
     * @return        the collection of vertices that are neighbors of vertex
     *                null if the vertex is not contained in the graph
     */
    public LinkedList<V> getNeighbors(V vertex) {
        if (!containsVertex(vertex)) {
            return null;
        }

        LinkedList<V> neighbors = new LinkedList<V>();
        int vertexIndex = verticesMap.get(vertex);

        for (int i = 0; i != verticesCount; i++) {
            if (edges[vertexIndex][i] != null || edges[i][vertexIndex] != null) {
                neighbors.add(verticesArray.get(i));
            }
        }

        return neighbors;
    }

    /** 
     * Get the number of neighbors for a vertex, both incident and outer
     * @param  vertex the specified vertex
     * @return        number of neighbors, -1 if vertex is not contained in graph
     */
    public int countNeighbors(V vertex) {
        if (!containsVertex(vertex)) {
            return -1;
        }

        return getNeighbors(vertex).size();
    }

    /**
     * Get how many edges the graph contains.
     * @return number of edges
     */
    public int countEdges() {
        int count = 0;

        for (int i = 0; i != verticesCount; i++) {
            for (int j = 0; j != verticesCount; j++) {
                if (edges[i][j] != null) {
                    count++;
                }
            }
        }
        System.out.println(count);

        return 0;
    }

    /**
     * Get the incident vertices of a vertex.
     * @param  vertex the specified vertex
     * @return        a LinkedList containing the incident vertices of vertex,
     *                null if vertex is not contained in the graph
     */
    public LinkedList<V> getInVertices(V vertex) {
        if (!containsVertex(vertex)) {
            return null;
        }

        LinkedList<V> neighbors = new LinkedList<V>();
        int vertexIndex = verticesMap.get(vertex);

        for (int i = 0; i != verticesCount; i++) {
            if (edges[i][vertexIndex] != null) {
                neighbors.add(verticesArray.get(i));
            }
        }

        return neighbors;
    }

    /**
     * Get the outer vertices of a vertex.
     * @param  vertex the specified vertex
     * @return        a LinkedList containing the outer vertices of vertex,
     *                null if vertex is not contained in the graph
     */
    public LinkedList<V> getOutVertices(V vertex) {
        if (!containsVertex(vertex)) {
            return null;
        }

        LinkedList<V> neighbors = new LinkedList<V>();
        int vertexIndex = verticesMap.get(vertex);

        for (int i = 0; i != verticesCount; i++) {
            if (edges[vertexIndex][i] != null) {
                neighbors.add(verticesArray.get(i));
            }
        }

        return neighbors;
    }

    /**
     * Get the number of incident vertices of a vertex.
     * @param  vertex the specified vertex
     * @return        the number of incident vertices of vertex, -1 if vertex
     *                is not contained in the graph
     */
    public int getInDegree(V vertex) {
        LinkedList<V> list = getInVertices(vertex);

        if (list != null) {
            return list.size();
        }

        return -1;
    }

    /**
     * Get the number of outer vertices of a vertex.
     * @param  vertex the specified vertex
     * @return        the number of outer vertices of vertex, -1 if vertex
     *                is not contained in the graph
     */
    public int getOutDegree(V vertex) {
        LinkedList<V> list = getOutVertices(vertex);

        if (list != null) {
            return list.size();
        }

        return -1;
    }

    /**
     * Does a path exists between source and destination.
     * @param source      source vertex
     * @param destination destination vertex
     * @return            true if a path exists
     */
    public boolean existsPath(V source, V destination) {
        return true;
    }

    public LinkedList<V> getPath(V source, V destination) {
        return new LinkedList<V>();
    }

    /**
     * Get a spanning tree if it exists.
     * @return Graph containing a spanning tree if it exists, null otherwise.
     */
    public DirectedGraph<V> getSpanningTree() {
        return null;
    }
}
