package org.simplegraph.impl;

import org.junit.jupiter.api.BeforeEach;

import org.simplegraph.impl.*;

public class TestUndirectedSparseGraph extends TestUndirectedGraph {
    @BeforeEach
    public void init() {
        setGraph(new UndirectedSparseGraph<String>());
    }
}
