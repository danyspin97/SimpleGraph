package org.simplegraph.impl;

import org.junit.jupiter.api.BeforeEach;

public class TestUndirectedSparseGraph extends TestUndirectedGraph {
    @BeforeEach
    public void init() {
        setGraph(new UndirectedSparseGraph<String>());
    }
}
