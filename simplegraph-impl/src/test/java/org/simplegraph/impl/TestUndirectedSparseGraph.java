package org.simplegraph.impl;

import org.junit.Before;

import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import org.simplegraph.impl.*;

public class TestUndirectedSparseGraph extends TestUndirectedGraph {
    @Rule
    public final TestRule rule1 = new TestRule() {
         
        public Statement apply(Statement base, Description description) {
            g = new UndirectedSparseGraph<String>();
            return base;
        }
    };  
}
