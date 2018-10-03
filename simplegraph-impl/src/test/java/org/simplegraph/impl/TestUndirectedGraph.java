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
        assertEquals(g.countEdges(), edgesCount + 1);
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
}
