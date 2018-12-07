package org.simplegraph.impl;

import org.junit.jupiter.api.BeforeEach;

import org.simplegraph.util.SimpleWeight;

public class TestDirectedWeightedSparseGraph extends TestDirectedWeightedGraph {
    @BeforeEach
    public void init() {
        setGraph(new DirectedWeightedSparseGraph<String, SimpleWeight>());
    }
}
