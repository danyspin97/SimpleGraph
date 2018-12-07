package org.simplegraph.impl;

import org.junit.jupiter.api.BeforeEach;

import org.simplegraph.DirectedSparseGraph;

public class TestDirectedSparseGraph extends TestDirectedGraph {
    @BeforeEach
    public void init() {
        setGraph(new DirectedSparseGraph<String>());
    }
}
