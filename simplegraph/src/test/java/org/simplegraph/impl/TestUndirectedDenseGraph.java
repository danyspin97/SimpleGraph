package org.simplegraph.impl;

import org.junit.jupiter.api.BeforeEach;

public class TestUndirectedDenseGraph extends TestUndirectedGraph {
    @BeforeEach
    public void init() {
        setGraph(new DenseGraph<String>());
    }
}
