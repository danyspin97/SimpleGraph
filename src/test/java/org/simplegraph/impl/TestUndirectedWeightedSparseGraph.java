package org.simplegraph.impl;

import org.junit.jupiter.api.BeforeEach;

import org.simplegraph.impl.*;
import org.simplegraph.*;
import org.simplegraph.util.*;

public class TestUndirectedWeightedSparseGraph extends TestWeightedEdgesGraph {
    @BeforeEach
    public void init() {
        setGraph(new UndirectedWeightedSparseGraph<String, SimpleWeight>());
    }
}
