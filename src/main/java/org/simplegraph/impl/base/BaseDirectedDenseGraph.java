package org.simplegraph.impl.base;

import java.util.Arrays;
import java.util.ArrayDeque;
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

        // Set all the unused positions to null
        for (int i = 0; i != size; ++i) {
            for (int j = oldSize; j != size; j++) {
                newMatrix[i][j] = null;
                newMatrix[j][i] = null;
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
            // the first is not contained but it's the same as the second
            if (v1.equals(v2)) {
                return false;
            }

            addVertex(v1);
            // get the index of the newly added vertex
            i1 = getVertexIndex(v1);
        }

        if (i2 == -1) {
            addVertex(v2);
            i2 = getVertexIndex(v2);
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

        return count;
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

        // If there is only one vertex
        if (verticesCount == 1) {
            return neighbors;
        }

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
        LinkedList<V> path = getPath(source, destination);
        if (path == null) {
            return false;
        }

        return path.size() != 0;
    }

    /**
     * Get a path between a source and a destination
     * @param  source      The vertex from where the path shall begin
     * @param  destination The vertex from where the path shall end
     * @return             Ordered LinkedList of the vertices that form a path
     *                     between source and destination, null if source
     *                     and destination are the same or if they are not
     *                     contained in the graph, an empty LinkedList if
     *                     there is no path between them
     */
    public LinkedList<V> getPath(V source, V destination) {
        int i1, i2;

        if ((i1 = getVertexIndex(source)) == -1 || (i2 = getVertexIndex(destination)) == -1) {
            return null;
        }

        if (i1 == i2) {
            return null;
        }

        int parent[] = new int[verticesCount];
        Arrays.fill(parent, -1);
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>(verticesCount * verticesCount);
        queue.add(i1);

        Integer current = -1;
        int row;

        while ((current = queue.pollFirst()) != null) {

            if (current == i2) {
                break;
            }

            // Iterate over "current" neighbors
            for (int i = 0; i != verticesCount; i++) {
                // If the vertex has not been processes
                if (edges[current][i] != null && parent[i] == -1) {
                    queue.add(i);
                    parent[i] = current;
                }
            }
        }

        LinkedList<V> path = new LinkedList<V>();

        if (current != null && current == i2) {

            do {
                path.addFirst(verticesArray.get(current));
            } while ((current = parent[current]) != i1);

            path.addFirst(source);
            return path;
        }

        return path;
    }

    /**
     * Get a spanning tree if it exists.
     * @return Graph containing a spanning tree if it exists, null otherwise.
     */
    public DirectedGraph<V> _getSpanningTree() {
        return null;
    }
}
