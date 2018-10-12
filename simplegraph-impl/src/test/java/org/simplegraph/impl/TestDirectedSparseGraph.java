package org.simplegraph.impl;

import org.junit.jupiter.api.BeforeEach;

import org.simplegraph.impl.*;
import org.simplegraph.*;

public class TestDirectedSparseGraph extends TestDirectedGraph {
    @BeforeEach
    public void init() {
        dg = new DirectedSparseGraph<String>();
        g = dg;
    }
}
