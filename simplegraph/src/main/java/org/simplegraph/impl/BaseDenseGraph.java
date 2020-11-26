package org.simplegraph.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;

abstract class BaseDenseGraph<V> {
    protected static final short DEFAULT_SIZE = 15;
    protected int size;
    protected int verticesCount;
    protected ArrayList<V> verticesArray;
    protected Map<V, Integer> verticesMap;

    protected void initialize(int startSize) {
        size = startSize;

        verticesArray = new ArrayList<V>(size);

        // Fill vertices array with null
        for (int i = 0; i != size; ++i) {
            verticesArray.add(null);
        }

        // We expect the hashmap to be full
        verticesMap = new HashMap<V, Integer>(size, 1);
        verticesCount = 0;
    }

    protected void copyVertices(BaseDenseGraph<V> graph) {
        size = graph.size;
        verticesCount = graph.verticesCount;
        for (int i = 0; i != verticesCount; i++) {
            V v = graph.verticesArray.get(i);
            if (v != null) {
                verticesMap.put(v, i);
                verticesArray.add(i, v);
                continue;
            }
            verticesArray.set(i, null);
        }

        for (int i = verticesCount; i != size; i++) {
            verticesArray.set(i, null);
        }
    }

    /**
     * Grow the graph size to the specified size
     * @param newSize New size for the graph.
     */
    public void grow(int newSize) {
        if (newSize < size) {
            return;
        }

        int oldSize = size;
        size = newSize;

        verticesArray.ensureCapacity(size);

        for (int i = oldSize; i != size; ++i) {
            verticesArray.add(null);
        }
    }

    /**
     * Get index of the vertex.
     * @param vertex Selected vertex.
     * @return Index of the selected vertex.
     */
    protected int getVertexIndex(V vertex) {
        // null is not a valid vertex
        if (vertex == null) {
            return -1;
        }

        return verticesMap.getOrDefault(vertex, -1);
    }

    /**
     * Add a vertex to the graph.
     * @param  vertex the vertex to add
     * @return        true if the the graph has been modified
     */
    public boolean addVertex(V vertex) {
        // null is not a valid vertex
        if (vertex == null) {
            return false;
        }

        if (containsVertex(vertex)) {
            return false;
        }

        // Add the vertex to both the array and the map
        // verticesCount is at most size - 1
        // using it as index is safe
        verticesArray.set(verticesCount, vertex);
        verticesMap.put(vertex, verticesCount);

        verticesCount++;

        // No need to add null edges because we already added them when
        // we initialized/grown the graph

        // Has we reached the max size?
        if (verticesCount == size) {
            grow(size * 2);
        }

        return true;
    }

    /**
     * Remove a vertex from the graph
     * @param  vertex the vertex to remove
     * @return        true if the graph has been modified
     */
    public boolean removeVertex(V vertex) {
        if (!containsVertex(vertex)) {
            return false;
        }

        // Do not check if vertex is the last one
        // because it works too

        verticesCount--;

        // Swap the last vertex with the one to remove
        int vertexIndex = verticesMap.get(vertex);
        // we use verticesCount as index because it has already been decreased
        verticesMap.replace(verticesArray.get(verticesCount), vertexIndex);
        verticesMap.remove(vertex);
        verticesArray.set(vertexIndex, verticesArray.get(verticesCount));
        verticesArray.set(verticesCount, null);

        return true;
    }

    /**
     * Check the existence of a vertex in the graph.
     * @param  vertex the vertex to check
     * @return        true if the graph contains vertex
     */
    public boolean containsVertex(V vertex) {
        if (vertex == null) {
            return false;
        }

        if (verticesCount == 0) {
            return false;
        }

        return verticesMap.containsKey(vertex);
    }

    /**
     * Get the number of vertices in the graph.
     * @return number of vertices
     */
    public int countVertices() {
        return verticesCount;
    }

    /**
     * Get all the vertices in the graph
     * @return a List containing all the graph vertices
     */
    public List<V> getVertices() {
        return new LinkedList<V>(verticesArray.subList(0, verticesCount));
    }
}
