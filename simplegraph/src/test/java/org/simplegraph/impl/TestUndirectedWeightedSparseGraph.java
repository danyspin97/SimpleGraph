package org.simplegraph.impl;

import org.junit.jupiter.api.BeforeEach;

public class TestUndirectedWeightedSparseGraph extends TestWeightedEdgesGraph {
    @BeforeEach
    public void init() {
        setGraph(new WeightedSparseGraph<String>());
    }
}
