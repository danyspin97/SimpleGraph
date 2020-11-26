package org.simplegraph.impl;

import org.junit.jupiter.api.BeforeEach;

public class TestDirectedWeightedSparseGraph extends TestDirectedWeightedGraph {
    @BeforeEach
    public void init() {
        setGraph(new DirectedWeightedSparseGraph<String>());
    }
}
