package org.simplegraph.impl;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestUndirectedSparseGraph extends TestUndirectedGraph {
    static public SparseGraph<String> g = new SparseGraph<String>();

    @BeforeEach
    public void init() {
        setGraph(new SparseGraph<String>());
    }

    @Test
    public void testCopy() {
        g.addEdge("Vertex1", "Vertex2");
        g.addEdge("Vertex2", "Vertex3");

        SparseGraph<String> gCopy = new SparseGraph<String>(g);
        assertTrue(gCopy.existsEdge("Vertex1", "Vertex2"));
        assertTrue(gCopy.existsEdge("Vertex3", "Vertex2"));

        gCopy.removeEdge("Vertex1", "Vertex2");
        assertFalse(gCopy.existsEdge("Vertex1", "Vertex2"));
        assertTrue(g.existsEdge("Vertex1", "Vertex2"));
    }
}
