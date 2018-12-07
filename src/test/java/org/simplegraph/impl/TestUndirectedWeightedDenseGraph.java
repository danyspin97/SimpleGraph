package org.simplegraph.impl;

import org.junit.jupiter.api.BeforeEach;

import org.simplegraph.util.SimpleWeight;

public class TestUndirectedWeightedDenseGraph extends TestWeightedEdgesGraph {
    @BeforeEach
    public void init() {
        setGraph(new UndirectedWeightedDenseGraph<String, SimpleWeight>());
    }
}
