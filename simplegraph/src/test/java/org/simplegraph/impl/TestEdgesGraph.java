package org.simplegraph.impl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import org.simplegraph.Graph;

public abstract class TestEdgesGraph {
    static public Graph<String> g;

    public void setGraph(Graph<String> g) {
        this.g = g;
    }

	@Test
	public void testAddVertex() {
        int size = g.countVertices();
        g.addVertex("A");
        // Assert that the size has been increased
		assertEquals(g.countVertices(), size + 1);
	}

    // If the vertex is the same, than it is not added
    @Test
    public void testAddSameVertex() {
        g.addVertex("B");
        int size = g.countVertices();
        g.addVertex("B");
        // Assert that the size has been increased
		assertEquals(g.countVertices(), size);
    }

    // Add a large number of vertices
    @Test
    public void testAddLargeNumberOfVertices() {
        int size = g.countVertices();
        int verticesToAdd = 100;
        for (int i = 0; i != verticesToAdd; i++) {
            g.addVertex(String.valueOf(i));
        }

        assertEquals(g.countVertices(), size + verticesToAdd);
    }

    @Test
    public void testRemoveSingleVertex() {
        g.addVertex("O");
        int size = g.countVertices();
        g.removeVertex("O");
        assertEquals(g.countVertices(), size - 1);
    }

    @Test
    public void testRemoveLargeNumberOfVertices() {
        int verticesToAdd = 100;
        for (int i = 0; i != verticesToAdd; i++) {
            g.addVertex(String.valueOf(i));
        }

        int size = g.countVertices();
        int verticesToRemove = 50;

        for (int i = 0; i != verticesToRemove; i++) {
            g.removeVertex(String.valueOf(i));
        }

        assertEquals(g.countVertices(), size - verticesToRemove);
    }

    @Test
    public void testRemoveVertexNotAdded() {
        assertFalse(g.removeVertex("A"));
    }

    @Test
    public void testAddNullVertex() {
        assertFalse(g.addVertex(null));
    }

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
        g.addEdge("A", "B");
        assertTrue(g.existsEdge("A", "B"));
    }

    @Test
    public void testAddEdgesBetweenSameVertexNotContained() {
        assertFalse(g.addEdge("A", "A"));
        assertFalse(g.containsVertex("A"));
    }

    @Test
    public void testCountEdges() {
        int edgesCount = g.countEdges();
        g.addEdge("C", "D");
        g.addEdge("E", "F");
        assertEquals(edgesCount + 2, g.countEdges());
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

    @Test
    public void testExistsPath() {
        g.addEdge("A", "B");
        g.addEdge("B", "C");
        g.addEdge("C", "D");
        assertTrue(g.existsPath("A", "D"));
    }

    @Test
    public void testPathBetweenNonExistentVertices() {
        assertFalse(g.existsPath("A", "B"));
    }

    @Test
    public void testExistsPathInNullPath() {
        g.addEdge("A", "C");
        g.addEdge("D", "B");
        assertFalse(g.existsPath("A", "B"));
    }

    @Test
    public void testGetPath() {
        g.addEdge("A", "B");
        g.addEdge("B", "C");
        List<String>  path = g.getPath("A", "C");
        assertArrayEquals(new String[] { "A", "B", "C" }, path.toArray());
    }

    @Test
    public void testPathDoesNotExists() {
        g.addEdge("A", "B");
        g.addEdge("C", "D");
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
}
