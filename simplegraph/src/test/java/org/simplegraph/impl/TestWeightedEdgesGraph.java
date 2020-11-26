package org.simplegraph.impl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import org.simplegraph.WeightedGraph;

public abstract class TestWeightedEdgesGraph extends TestVerticesGraph {
    static public WeightedGraph<String> g;

    public void setGraph(WeightedGraph<String> g) {
        this.g = g;
        super.setGraph(g);
    }

    @Test
    public void testAddEdge() {
        g.addVertex("C");
        g.addVertex("D");
        assertTrue(g.addEdge("C", "D", 1.d));
    }

    @Test
    public void testExistsEdge() {
        g.addVertex("C");
        g.addVertex("D");
        g.addEdge("C", "D", 1.d);
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
        g.addEdge("A", "B", 1.d);
        assertTrue(g.existsEdge("A", "B"));
    }

    @Test
    public void testAddEdgesBetweenSameVertex() {
        assertFalse(g.addEdge("A", "A", 1.d));
    }

    @Test
    public void testAddEdgesBetweenSameVertexNotContained() {
        g.addEdge("A", "A", 1.d);
        assertFalse(g.containsVertex("A"));
    }

    @Test
    public void testCountEdgesEmptyGraph() {
        assertEquals(0, g.countEdges());
    }

    @Test
    public void testCountEdges() {
        g.addEdge("C", "D", 1.d);
        g.addEdge("E", "F", 1.d);
        assertEquals(2, g.countEdges());
    }

    @Test
    public void testAddEdgeBetweenNullVertices() {
        assertFalse(g.addEdge(null, null, 1.d));
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
            g.addEdge(String.valueOf(Math.random() * verticesToAdd), String.valueOf(Math.random() * verticesToAdd), 1.d);
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
            g.addEdge(String.valueOf(Math.random() * verticesToAdd), String.valueOf(Math.random() * Math.random()), 1.d);
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
        g.addEdge("A", "B", 1.d);
        assertTrue(g.removeEdge("A", "B"));
    }

    @Test
    public void testRemoveVertexWithEdges() {
        int verticesToAdd = 100;
        for (int i = 0; i != verticesToAdd; i++) {
            g.addVertex(String.valueOf(i));
        }

        for (int i = 0; i != verticesToAdd * 4; i++) {
            g.addEdge(String.valueOf(Math.random() * verticesToAdd), String.valueOf(Math.random() * Math.random()), 1.d);
        }

        for (String s : g.getVertices()) {
            g.removeVertex(s);
        }

        assertEquals(0, g.countEdges());
    }

    @Test
    public void testExistsPath() {
        g.addEdge("A", "B", 1.d);
        g.addEdge("B", "C", 1.d);
        g.addEdge("C", "D", 1.d);
        assertTrue(g.existsPath("A", "D"));
    }

    @Test
    public void testPathBetweenNonExistentVertices() {
        assertFalse(g.existsPath("A", "B"));
    }

    @Test
    public void testExistsPathInNullPath() {
        g.addEdge("A", "C", 1.d);
        g.addEdge("D", "B", 1.d);
        assertFalse(g.existsPath("A", "B"));
    }

    @Test
    public void testGetPath() {
        g.addEdge("A", "B", 1.d);
        g.addEdge("B", "C", 1.d);
        List<String>  path = g.getPath("A", "C");
        assertArrayEquals(new String[] { "A", "B", "C" }, path.toArray());
    }

    @Test
    public void testPathDoesNotExists() {
        g.addEdge("A", "B", 1.d);
        g.addEdge("C", "D", 1.d);
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
        g.addEdge("A", "B", 1.d);
        assertFalse(g.addEdge("A", "B", 1.d));
    }

    @Test
    public void testGetEdge() {
        g.addEdge("A", "B", 1.d);
        assertEquals(1.d, (double) g.getWeight("A", "B"));
    }

    @Test
    public void testGetShortestPath() {
        g.addEdge("A", "B", 10.d);
        g.addEdge("A", "C", 50.d);
        g.addEdge("B", "D", 10.d);
        g.addEdge("C", "D", 50.d);
        List<String>  path = g.getShortestPath("A", "D");
        assertArrayEquals(new String[] { "A", "B", "D" }, path.toArray());
    }

    @Test
    public void testGetShortestPathNegativeWeight() {
        g.addEdge("A", "B", 10.d);
        g.addEdge("A", "C", 50.d);
        g.addEdge("B", "D", -10.d);
        g.addEdge("C", "D", -200.d);
        List<String> path = g.getShortestPath("A", "D");
        assertEquals(path, null);
        assertNull(path);
    }

    @Test
    public void testGetMinimumDistance() {
        g.addEdge("A", "B", 10.d);
        g.addEdge("A", "C", 50.d);
        g.addEdge("B", "D", 20.d);
        g.addEdge("C", "D", 200.d);
        assertEquals(30.d, (double)g.getMinimumDistance("A", "D"));
    }
}
