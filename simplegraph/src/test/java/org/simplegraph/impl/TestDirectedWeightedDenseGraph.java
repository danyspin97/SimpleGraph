package org.simplegraph.impl;

import org.junit.jupiter.api.BeforeEach;

public class TestDirectedWeightedDenseGraph extends TestDirectedWeightedGraph {
    @BeforeEach
    public void init() {
        setGraph(new DirectedWeightedDenseGraph<String>());
    }
}
