package org.simplegraph.impl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import org.simplegraph.WeightedGraph;
import org.simplegraph.util.SimpleWeight;

public abstract class TestWeightedEdgesGraph extends TestVerticesGraph {
    static public WeightedGraph<String, SimpleWeight> g;
    static public SimpleWeight sw = new SimpleWeight(1);

    public void setGraph(WeightedGraph<String, SimpleWeight> g) {
        this.g = g;
        super.setGraph(g);
    }

    @Test
    public void testAddEdge() {
        g.addVertex("C");
        g.addVertex("D");
        assertTrue(g.addEdge("C", "D", sw));
    }

    @Test
    public void testExistsEdge() {
        g.addVertex("C");
        g.addVertex("D");
        g.addEdge("C", "D", sw);
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
        g.addEdge("A", "B", sw);
        assertTrue(g.existsEdge("A", "B"));
    }

    @Test
    public void testAddEdgesBetweenSameVertex() {
        assertFalse(g.addEdge("A", "A", sw));
    }

    @Test
    public void testAddEdgesBetweenSameVertexNotContained() {
        g.addEdge("A", "A", sw);
        assertFalse(g.containsVertex("A"));
    }

    @Test
    public void testCountEdgesEmptyGraph() {
        assertEquals(0, g.countEdges());
    }

    @Test
    public void testCountEdges() {
        g.addEdge("C", "D", sw);
        g.addEdge("E", "F", sw);
        assertEquals(2, g.countEdges());
    }

    @Test
    public void testAddEdgeBetweenNullVertices() {
        assertFalse(g.addEdge(null, null, sw));
    }

    public void testAddNullEdge() {
        assertFalse(g.addEdge("A", "B", null));
    }

    // Add a large number of edges
    @Test
    public void testAddLargeNumberOfEdges() {
        int edgesCount = g.countEdges();
        int verticesToAdd = 100;

        for (int i = 0; i != verticesToAdd * 4; i++) {
            g.addEdge(String.valueOf(Math.random() * verticesToAdd), String.valueOf(Math.random() * verticesToAdd), sw);
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
            g.addEdge(String.valueOf(Math.random() * verticesToAdd), String.valueOf(Math.random() * Math.random()), sw);
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
        g.addEdge("A", "B", sw);
        assertTrue(g.removeEdge("A", "B"));
    }

    @Test
    public void testRemoveVertexWithEdges() {
        int verticesToAdd = 100;
        for (int i = 0; i != verticesToAdd; i++) {
            g.addVertex(String.valueOf(i));
        }

        for (int i = 0; i != verticesToAdd * 4; i++) {
            g.addEdge(String.valueOf(Math.random() * verticesToAdd), String.valueOf(Math.random() * Math.random()), sw);
        }

        for (String s : g.getVertices()) {
            g.removeVertex(s);
        }

        assertEquals(0, g.countEdges());
    }

    @Test
    public void testExistsPath() {
        g.addEdge("A", "B", sw);
        g.addEdge("B", "C", sw);
        g.addEdge("C", "D", sw);
        assertTrue(g.existsPath("A", "D"));
    }

    @Test
    public void testPathBetweenNonExistentVertices() {
        assertFalse(g.existsPath("A", "B"));
    }

    @Test
    public void testExistsPathInNullPath() {
        g.addEdge("A", "C", sw);
        g.addEdge("D", "B", sw);
        assertFalse(g.existsPath("A", "B"));
    }

    @Test
    public void testGetPath() {
        g.addEdge("A", "B", sw);
        g.addEdge("B", "C", sw);
        List<String>  path = g.getPath("A", "C");
        assertArrayEquals(new String[] { "A", "B", "C" }, path.toArray());
    }

    @Test
    public void testPathDoesNotExists() {
        g.addEdge("A", "B", sw);
        g.addEdge("C", "D", sw);
        assertArrayEquals(new String[] {}, g.getPath("A", "D").toArray());
    }

    @Test
    public void testGetPathBetweenNonExistentVertices() {
        assertSame(null, g.getPath("A", "B"));
    }

    @Test
    public void testGetPathBetweenSameVertex() {
        g.addVertex("A");
        assertSame(null, g.getPath("A", "A"));
    }

    @Test
    public void testUpdateEdge() {
        g.addEdge("A", "B", sw);
        assertFalse(g.addEdge("A", "B", sw));
    }

    @Test
    public void testGetEdge() {
        g.addEdge("A", "B", sw);
        assertEquals(sw, g.getEdge("A", "B"));
    }
}
