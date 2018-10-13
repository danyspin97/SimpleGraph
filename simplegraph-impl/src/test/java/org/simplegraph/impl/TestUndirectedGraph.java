package org.simplegraph.impl;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import org.simplegraph.*;

public abstract class TestUndirectedGraph extends TestEdgesGraph {
    // The graph is undirected, so a,b is the same as b,a
    @Test
    public void testExistsOppositeEdge() {
        g.addEdge("A", "B");
        assertTrue(g.existsEdge("B", "A"));
    }

    @Test
    public void testAddOppositeEdge() {
        g.addEdge("E", "F");
        int edgesCount = g.countEdges();
        g.addEdge("F", "E");
        assertEquals(g.countEdges(), edgesCount);
    }

    // Remove a single edge
    @Test
    public void testRemoveOppositeEdge() {
        g.addVertex("A");
        g.addVertex("B");
        g.addEdge("A", "B");
        assertTrue(g.removeEdge("B", "A"));
    }
}
