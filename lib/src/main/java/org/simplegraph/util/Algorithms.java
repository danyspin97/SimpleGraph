package org.simplegraph.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.simplegraph.WeightedGraph;
import org.simplegraph.util.FibonacciHeap;

public class Algorithms {
    public static <V> List<V> getShortestPath(
            WeightedGraph g, V source, V destination) {
        if (!g.containsVertex(source) || !g.containsVertex(destination)) {
            return null;
        }

        // source != null
        if (source.equals(destination)) {
            return null;
        }

        List<V> vertices = g.getVertices();
        int verticesCount = vertices.size();
        FibonacciHeap.Entry<V> current;
        Set<V> visited = new HashSet<V>(verticesCount, 1);
        Map<V, V> prev = new HashMap<V, V>(verticesCount, 1);
        Map<V, FibonacciHeap.Entry<V>> entries = new HashMap<>(verticesCount, 1);
        prev.put(source, null);
        FibonacciHeap<V> queue = new FibonacciHeap<>();

        entries.put(source, queue.enqueue(source, 0));
        V currentVertex = null;

        while (queue.size() != 0) {
            current = queue.dequeueMin();
            currentVertex = current.getValue();

            if (currentVertex.equals(destination)) {
                break;
            }

            visited.add(currentVertex);

            for (Object o: g.getNeighbors(currentVertex)) {
                V neighbor = (V) o;
                if (visited.contains(neighbor)) {
                    continue;
                }

                double weight = g.getWeight(currentVertex, neighbor);
                if (weight == Double.POSITIVE_INFINITY) {
                    continue;
                }
                //
                // Dijkstra algorithm does not support negative weight
                if (weight < 0) {
                    return null;
                }

                try {
                    if (prev.containsKey(neighbor)) {
                        queue.decreaseKey(entries.get(neighbor), weight + current.getPriority());
                    } else {
                        entries.put(neighbor, queue.enqueue(neighbor, weight + current.getPriority()));
                    }
                    prev.put(neighbor, currentVertex);
                } catch (IllegalArgumentException e) {

                }
            }
        }

        if (currentVertex != destination) {
            return new LinkedList<V>();
        }

        LinkedList<V> path = new LinkedList<V>();
        path.add(destination);

        while (!currentVertex.equals(source)) {
            currentVertex = prev.get(currentVertex);
            path.addFirst(currentVertex);
        }

        return path;
    }

    public static <V> double getMinimumDistance(
            WeightedGraph<V> g, V source, V destination
            ) {
        List<V> path = g.getShortestPath(source, destination);
        ListIterator<V> iter = path.listIterator(1);
        V current = source;
        V next = null;
        double total = 0;
        while(iter.hasNext()) {
            next = iter.next();
            total += g.getWeight(current, next);
            current = next;
        }

        return total;
    }

    public static <V> WeightedGraph<V> getMinimumSpanningTree(WeightedGraph<V> g) {
        return null;
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
    }
}
