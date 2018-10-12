package org.simplegraph.impl;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import org.simplegraph.*;

public abstract class TestDirectedGraph extends TestEdgesGraph {
    public DirectedGraph<String> dg;

    // The graph is undirected, so a,b is the same as b,a
    @Test
    public void testAddOppositeEdge() {
        g.addEdge("E", "F");
        int edgesCount = g.countEdges();
        g.addEdge("F", "E");
        assertEquals(edgesCount + 1, g.countEdges());
    }

    @Test
    public void testExistsOppositeEdge() {
        g.addEdge("E", "F");
        assertFalse(g.existsEdge("F", "E"));
    }

    // Remove a single edge
    @Test
    public void testRemoveOppositeEdge() {
        g.addEdge("A", "B");
        assertFalse(g.removeEdge("B", "A"));
    }

    @Test
    public void testGetInDegree() {
        g.addEdge("A", "B");
        assertSame(1, dg.getInDegree("B"));
    }

    @Test
    public void testGetOutDegree() {
        g.addEdge("A", "B");
        assertSame(1, dg.getOutDegree("A"));
    }

    @Test
    public void testGetInVertices() {
        g.addEdge("A", "C");
        g.addEdge("B", "C");
        String[] expectedArray = {"A", "B"};
        assertArrayEquals(expectedArray, dg.getInVertices("C").toArray());
    }

    @Test
    public void testGetOutVertices() {
        g.addEdge("C", "A");
        g.addEdge("C", "B");
        assertArrayEquals(new String[] {"A", "B"}, dg.getOutVertices("C").toArray());
    }
}
