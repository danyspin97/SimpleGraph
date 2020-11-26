package org.simplegraph.impl;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import org.simplegraph.DirectedWeightedGraph;

public abstract class TestDirectedWeightedGraph extends TestWeightedEdgesGraph {
    public DirectedWeightedGraph<String> g;

    public void setGraph(DirectedWeightedGraph<String> g) {
        this.g = g;
        super.setGraph(g);
    }

    // The graph is undirected, so a,b is the same as b,a
    @Test
    public void testAddOppositeEdge() {
        g.addEdge("E", "F", 1.d);
        int edgesCount = g.countEdges();
        g.addEdge("F", "E", 1.d);
        assertEquals(edgesCount + 1, g.countEdges());
    }

    @Test
    public void testExistsOppositeEdge() {
        g.addEdge("E", "F", 1.d);
        assertFalse(g.existsEdge("F", "E"));
    }

    // Remove a single edge
    @Test
    public void testRemoveOppositeEdge() {
        g.addEdge("A", "B", 1.d);
        assertFalse(g.removeEdge("B", "A"));
    }

    @Test
    public void testGetInDegree() {
        g.addEdge("A", "B", 1.d);
        assertSame(1, g.getInDegree("B"));
    }

    @Test
    public void testGetOutDegree() {
        g.addEdge("A", "B", 1.d);
        assertSame(1, g.getOutDegree("A"));
    }

    @Test
    public void testGetInVertices() {
        g.addEdge("A", "C", 1.d);
        g.addEdge("B", "C", 1.d);
        String[] expectedArray = {"A", "B"};
        assertArrayEquals(expectedArray, g.getInVertices("C").toArray());
    }

    @Test
    public void testGetOutVertices() {
        g.addEdge("C", "A", 1.d);
        g.addEdge("C", "B", 1.d);
        assertArrayEquals(new String[] {"A", "B"}, g.getOutVertices("C").toArray());
    }
}
