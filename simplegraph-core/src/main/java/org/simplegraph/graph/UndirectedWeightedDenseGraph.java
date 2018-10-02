package org.simplegraph.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Random;
import java.util.function.UnaryOperator;
import org.simplegraph.interfaces.WeightedGraph;

/**
 * Undirected graph implemention for dense graphs.
 */
public class UndirectedWeightedDenseGraph<V, E> extends BaseUndirectedDenseGraph<V, E> implements WeightedGraph<V, E> {
    protected ArrayList<E> edges;

    public UndirectedWeightedDenseGraph() {
        super();
    }

    public UndirectedWeightedDenseGraph(int size)
    {
        super(size);
    }

    public UndirectedWeightedDenseGraph(UndirectedWeightedSparseGraph<V, E> graph) {
        super(graph);
    }

    /**
     * Add an edge between two vertices.
     * Add the two vertices in the graph if they don't exists
     * @param  v1   first vertex
     * @param  v2   second vertex
     * @param  edge edge to add
     * @return      true if the graph has been modified
     */
    public boolean addEdge(V v1, V v2, E edge) {
        return _addEdge(v1, v2, edge);
    }

    public WeightedGraph<V, E> getSpanningTree() {
        return new UndirectedWeightedDenseGraph<V, E>(_getSpanningTree());
    }

    public E getMinimumDistance(V source, V destination) {
        return null;
    }

    public LinkedList<V> getShortestPath(V source, V destination) {
        return null;
    }

    public WeightedGraph<V, E> getMinimumSpanningTree() {
        return getMinimumSpanningTree();
    }
}
