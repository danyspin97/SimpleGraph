package org.simplegraph.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.simplegraph.*;

public abstract class TestVerticesGraph {
    static public Graph<String> g;

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
}
