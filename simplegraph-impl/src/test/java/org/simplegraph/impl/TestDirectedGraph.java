package org.simplegraph.impl;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import org.simplegraph.*;

public abstract class TestDirectedGraph extends TestEdgesGraph {
    // The graph is undirected, so a,b is the same as b,a
    @Test
    public void testAddOppositeEdge() {
        g.addVertex("E");
        g.addVertex("F");
        g.addEdge("E", "F");
        int edgesCount = g.countEdges();
        g.addEdge("F", "E");
        assertEquals(edgesCount + 1, g.countEdges());
    }

    // Remove a single edge
    @Test
    public void testRemoveOppositeEdge() {
        g.addVertex("A");
        g.addVertex("B");
        g.addEdge("A", "B");
        assertFalse(g.removeEdge("B", "A"));
    }
}
