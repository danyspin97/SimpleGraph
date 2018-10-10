package org.simplegraph.impl;

import static org.junit.Assert.*; // Allows you to use directly assert methods, such as assertTrue(...), assertNull(...)
import org.junit.Test;
import org.junit.Before;

import org.simplegraph.*;

public abstract class TestUndirectedGraph extends TestVerticesGraph {

    @Test
    public void testAddEdge() {
        int edgesCount = g.countEdges();
        g.addVertex("C");
        g.addVertex("D");
        g.addEdge("C", "D");
        assertEquals(edgesCount + 1, g.countEdges());
    }

    // The graph is undirected, so a,b is the same as b,a
    @Test
    public void testAddOppositeEdge() {
        g.addVertex("E");
        g.addVertex("F");
        g.addEdge("E", "F");
        int edgesCount = g.countEdges();
        g.addEdge("F", "E");
        assertEquals(g.countEdges(), edgesCount);
    }

    // Add a large number of edges
    @Test
    public void testAddLargeNumberOfEdges() {
        int edgesCount = g.countEdges();
        int verticesToAdd = 100;
        for (int i = 0; i != verticesToAdd; i++) {
            g.addVertex(String.valueOf(i));
        }

        for (int i = 0; i != verticesToAdd * 4; i++) {
            g.addEdge(String.valueOf(Math.random() * verticesToAdd), String.valueOf(Math.random() * Math.random()));
        }

        assertEquals(g.countEdges(), edgesCount + verticesToAdd * 4);
    }

    // Remove a large number of edges
    @Test
    public void testRemoveLargeNumberOfEdges() {
        int verticesToAdd = 100;
        for (int i = 0; i != verticesToAdd; i++) {
            g.addVertex(String.valueOf(i));
        }

        for (int i = 0; i != verticesToAdd * 4; i++) {
            g.addEdge(String.valueOf(Math.random() * verticesToAdd), String.valueOf(Math.random() * Math.random()));
        }

        for (String s : g.getVertices()) {
            for (String n : g.getNeighbors(s)){
                g.removeEdge(s, n);   
            }
        }

        assertEquals(0, g.countEdges());
    }

    // Remove a single edge
    @Test
    public void testRemoveEdge() {
        g.addVertex("A");
        g.addVertex("B");
        g.addEdge("A", "B");
        assertTrue(g.removeEdge("A", "B"));
    }

    @Test
    public void testRemoveVertexWithEdges() {
        int verticesToAdd = 100;
        for (int i = 0; i != verticesToAdd; i++) {
            g.addVertex(String.valueOf(i));
        }

        for (int i = 0; i != verticesToAdd * 4; i++) {
            g.addEdge(String.valueOf(Math.random() * verticesToAdd), String.valueOf(Math.random() * Math.random()));
        }

        for (String s : g.getVertices()) {
            g.removeVertex(s);
        }

        assertEquals(0, g.countEdges());
    }
}
