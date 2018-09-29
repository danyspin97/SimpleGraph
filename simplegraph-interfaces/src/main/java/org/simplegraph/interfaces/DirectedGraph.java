package org.simplegraph.interfaces;

import java.util.LinkedList;
import org.simplegraph.interfaces.Graph;

public interface DirectedGraph<V> extends Graph<V> {
    public int getInDegree(V vertex);
    
    public int getOutDegree(V vertex);

    public LinkedList<V> getInVertices(V vertex);

    public LinkedList<V> getOutVertices(V vertex);
}
