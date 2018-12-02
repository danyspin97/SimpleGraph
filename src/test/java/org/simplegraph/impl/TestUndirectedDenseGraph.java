package org.simplegraph.impl;

import org.junit.jupiter.api.BeforeEach;

import org.simplegraph.impl.*;
import org.simplegraph.Graph;

public class TestUndirectedDenseGraph extends TestUndirectedGraph {
    @BeforeEach
    public void init() {
        setGraph(new UndirectedDenseGraph<String>());
    }
}
