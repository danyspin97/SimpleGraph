package org.simplegraph;

import java.util.LinkedList;

public interface DirectedGraph<V> extends Graph<V> {
    public int getInDegree(V vertex);
    
    public int getOutDegree(V vertex);

    public LinkedList<V> getInVertices(V vertex);

    public LinkedList<V> getOutVertices(V vertex);
}
