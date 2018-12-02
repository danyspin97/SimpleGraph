package org.simplegraph.impl;

import org.junit.jupiter.api.BeforeEach;

import org.simplegraph.impl.*;
import org.simplegraph.*;
import org.simplegraph.util.*;

public class TestDirectedWeightedDenseGraph extends TestDirectedWeightedGraph {
    @BeforeEach
    public void init() {
        setGraph(new DirectedWeightedDenseGraph<String, SimpleWeight>());
    }
}
