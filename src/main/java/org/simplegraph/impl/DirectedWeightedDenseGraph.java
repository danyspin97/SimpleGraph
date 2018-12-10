package org.simplegraph.impl;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.simplegraph.DirectedWeightedGraph;
import org.simplegraph.impl.base.BaseDirectedDenseGraph;
import org.simplegraph.util.FibonacciHeap;
import org.simplegraph.util.Algorithms;

/**
 * Undirected graph implemention for dense graphs.
 */
public class DirectedWeightedDenseGraph<V> extends BaseDirectedDenseGraph<V, Double> implements DirectedWeightedGraph<V> {
    public DirectedWeightedDenseGraph() {
        initialize(DEFAULT_SIZE);
    }

    public DirectedWeightedDenseGraph(int size)
    {
        initialize(size);
    }

    public DirectedWeightedDenseGraph(DirectedWeightedDenseGraph<V> graph) {
        copy(graph);
    }


    /**
     * Add an edge that goes from the first vertex to the second.
     * Add the two vertices in the graph if they don't exists.
     * @param  v1   first vertex
     * @param  v2   second vertex
     * @param  edge edge to add
     * @return      true if the graph has been modified
     */
    public boolean addEdge(V v1, V v2, Double weight) {
        return addSingleEdge(v1, v2, weight);
    }

    /**
     * Get the edge that goes from the first vertex to the second.
     * @param  v1   first vertex
     * @param  v2   second vertex
     * @return      the edge from v1 to v2, if it exists, null otherwise
     */
    public Double getWeight(V v1, V v2) {
        return getSingleEdge(v1, v2);
    }

    public DirectedWeightedGraph<V> getSpanningTree() {
        return (DirectedWeightedDenseGraph<V>) _getSpanningTree();
    }

    public Double getMinimumDistance(V source, V destination) {
        return Algorithms.<V>getMinimumDistance(this, source, destination);
    }

    public List<V> getShortestPath(V source, V destination) {
        return Algorithms.<V>getShortestPath(this, source, destination);
    }

    public DirectedWeightedGraph<V> getMinimumSpanningTree() {
        // UndirectedDenseWeightedGraph<N, E> t = new UndirectedDenseWeightedGraph<N, E>(this);
        // // Remove all edges
        // int edgesSize = getEdgesSize(nodesCount);
        // for (int i = 0; i < edgesSize; i++) {
        //     t.edges.set(i, null);
        // }

        // // Select random node
        // int source = new Random((int) (System.currentTimeMillis() / 1000L)).nextInt(nodesCount);

        // FibonacciHeap.Entry<Integer> current;
        // boolean visited[] = new boolean[nodesCount];
        // int prev[] = new int[nodesCount];
        // ArrayList<FibonacciHeap.Entry<Integer>> entries = new ArrayList<FibonacciHeap.Entry<Integer>>(nodesCount);
        // prev[source] = source;
        // FibonacciHeap<Integer> queue = new FibonacciHeap<>();

        // for (int i = 0; i != nodesCount; ++i) {
        //     entries.add(queue.enqueue(Integer.valueOf(i), Integer.MAX_VALUE));
        // }

        // queue.decreaseKey(entries.get(source), 0);

        // int index = -1;

        // while (queue.size() != 0) {
        //     current = queue.dequeueMin();

        //     index = current.getValue();

        //     visited[index] = true;

        //     // Add the edge between the current node
        //     // and its precedent
        //     N currentNode = nodesArray.get(index);
        //     N prevNode = nodesArray.get(prev[index]);
        //     t.addEdge(currentNode, prevNode, getEdge(currentNode, prevNode));

        //     int i = -1;

        //     int row = getEdgesSize(index);

        //     while (++i != index) {

        //         if (visited[i] || edges.get(row + i) == null) {
        //             continue;
        //         }

        //         double distance = Double.parseDouble(edges.get(row + i).toString());

        //         if (distance < 0) {
        //             throw new IllegalArgumentException();
        //         }

        //         try {
        //             queue.decreaseKey(entries.get(i), Double.parseDouble(edges.get(row + i).toString()));
        //             prev[i] = index;

        //         } catch (IllegalArgumentException e) {
        //             // Don't do anything
        //         }
        //     }

        //     row += index;

        //     while (++i != nodesCount) {
        //         row += i;

        //         if (visited[i] || edges.get(row) == null) {
        //             continue;
        //         }

        //         try {
        //             queue.decreaseKey(entries.get(i), Double.parseDouble(edges.get(row).toString()));
        //             prev[i] = index;

        //         } catch (IllegalArgumentException e) {
        //             // Don't do anything
        //         }
        //     }
        // }

        // // Remove the node added in the first iteration
        // N sourceNode = nodesArray.get(source);
        // t.removeEdge(sourceNode, sourceNode);

        // return t;
    return null;
    }
}
