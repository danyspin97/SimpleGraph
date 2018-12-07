package org.simplegraph.impl;

import org.junit.jupiter.api.BeforeEach;

public class TestDirectedDenseGraph extends TestDirectedGraph {
    @BeforeEach
    public void init() {
        setGraph(new DirectedDenseGraph<String>());
    }
}
