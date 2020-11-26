package org.simplegraph.impl;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDirectedDenseGraph extends TestDirectedGraph {
    @BeforeEach
    public void init() {
        setGraph(new DirectedDenseGraph<String>());
    }

    // @Test
    // public void testCopyConstructor() {
    //     DirectedDenseGraph<String> g1 = new DirectedDenseGraph<String>();
    //     g1.addEdge("A", "B");
    //     g1.addEdge("B", "C");
    //     DirectedDenseGraph<String> g2 = new DirectedDenseGraph<String>(g1);
    //     assertEquals(g1, g2);
    // }

    // @Test
    // public void testInequality() {
    //     DirectedDenseGraph<String> g1 = new DirectedDenseGraph<String>();
    //     g1.addEdge("A", "B");
    //     DirectedDenseGraph<String> g2 = new DirectedDenseGraph<String>(g1);
    //     g2.addEdge("B", "C");
    //     assertNotEquals(g1, g2);
    // }
}
