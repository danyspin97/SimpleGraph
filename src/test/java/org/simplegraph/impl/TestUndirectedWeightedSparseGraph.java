package org.simplegraph.impl;

import org.junit.jupiter.api.BeforeEach;

import org.simplegraph.util.SimpleWeight;

public class TestUndirectedWeightedSparseGraph extends TestWeightedEdgesGraph {
    @BeforeEach
    public void init() {
        setGraph(new UndirectedWeightedSparseGraph<String, SimpleWeight>());
    }
}
