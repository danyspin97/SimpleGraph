package org.simplegraph.impl;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import org.simplegraph.*;
import org.simplegraph.util.*;

public abstract class TestDirectedWeightedGraph extends TestWeightedEdgesGraph {
    public DirectedWeightedGraph<String, SimpleWeight> g;

    public void setGraph(DirectedWeightedGraph<String, SimpleWeight> g) {
        this.g = g;
        super.setGraph(g);
    }

    // The graph is undirected, so a,b is the same as b,a
    @Test
    public void testAddOppositeEdge() {
        g.addEdge("E", "F", sw);
        int edgesCount = g.countEdges();
        g.addEdge("F", "E", sw);
        assertEquals(edgesCount + 1, g.countEdges());
    }

    @Test
    public void testExistsOppositeEdge() {
        g.addEdge("E", "F", sw);
        assertFalse(g.existsEdge("F", "E"));
    }

    // Remove a single edge
    @Test
    public void testRemoveOppositeEdge() {
        g.addEdge("A", "B", sw);
        assertFalse(g.removeEdge("B", "A"));
    }

    @Test
    public void testGetInDegree() {
        g.addEdge("A", "B", sw);
        assertSame(1, g.getInDegree("B"));
    }

    @Test
    public void testGetOutDegree() {
        g.addEdge("A", "B", sw);
        assertSame(1, g.getOutDegree("A"));
    }

    @Test
    public void testGetInVertices() {
        g.addEdge("A", "C", sw);
        g.addEdge("B", "C", sw);
        String[] expectedArray = {"A", "B"};
        assertArrayEquals(expectedArray, g.getInVertices("C").toArray());
    }

    @Test
    public void testGetOutVertices() {
        g.addEdge("C", "A", sw);
        g.addEdge("C", "B", sw);
        assertArrayEquals(new String[] {"A", "B"}, g.getOutVertices("C").toArray());
    }
}
