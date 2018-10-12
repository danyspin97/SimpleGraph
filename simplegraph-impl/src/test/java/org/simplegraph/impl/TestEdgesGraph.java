package org.simplegraph.impl;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import org.simplegraph.*;

public abstract class TestEdgesGraph extends TestVerticesGraph {
    @Test
    public void testAddEdge() {
        g.addVertex("C");
        g.addVertex("D");
        assertTrue(g.addEdge("C", "D"));
    }

    @Test
    public void testExistsEdge() {
        g.addVertex("C");
        g.addVertex("D");
        g.addEdge("C", "D");
        assertTrue(g.existsEdge("C", "D"));
    }

    @Test
    public void testNotExistsEdge() {
        g.addVertex("C");
        g.addVertex("D");
        assertFalse(g.existsEdge("C", "D"));
    }

    @Test
    public void testAddEdgeAndVertices() {
        assertTrue(g.addEdge("A", "B"));
        assertTrue(g.containsVertex("A"));
        assertTrue(g.containsVertex("B"));
        assertTrue(g.existsEdge("A", "B"));
    }

    @Test
    public void testCountEdges() {
        int edgesCount = g.countEdges();
        g.addVertex("C");
        g.addVertex("D");
        g.addEdge("C", "D");
        assertEquals(edgesCount + 1, g.countEdges());
    }

    @Test
    public void testAddEdgeBetweenNullVertices() {
        assertFalse(g.addEdge(null, null));
    }

    // Add a large number of edges
    @Test
    public void testAddLargeNumberOfEdges() {
        int edgesCount = g.countEdges();
        int verticesToAdd = 100;

        for (int i = 0; i != verticesToAdd * 4; i++) {
            g.addEdge(String.valueOf(Math.random() * verticesToAdd), String.valueOf(Math.random() * verticesToAdd));
        }

        assertNotSame(edgesCount, g.countEdges());
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
