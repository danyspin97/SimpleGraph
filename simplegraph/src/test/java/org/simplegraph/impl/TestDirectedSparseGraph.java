package org.simplegraph.impl;

import org.junit.jupiter.api.BeforeEach;

public class TestDirectedSparseGraph extends TestDirectedGraph {
    @BeforeEach
    public void init() {
        setGraph(new DirectedSparseGraph<String>());
    }
}
