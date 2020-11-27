package org.simplegraph.impl;

import org.junit.jupiter.api.BeforeEach;

public class TestUndirectedWeightedDenseGraph extends TestWeightedEdgesGraph {
    @BeforeEach
    public void init() {
        setGraph(new WeightedDenseGraph<String>());
    }
}
