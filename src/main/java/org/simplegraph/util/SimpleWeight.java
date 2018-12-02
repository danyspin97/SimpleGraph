package org.simplegraph.util;

import org.simplegraph.Weight;
import org.simplegraph.Summable;

public class SimpleWeight implements Weight<Double>, Summable<Double> {
    double weight;

    public SimpleWeight() {
        weight = 0;
    }

    public SimpleWeight(double d) {
        weight = d;
    }

    public Double getWeight() {
        return weight;
    }

    public boolean isInf() {
        return Double.POSITIVE_INFINITY == weight;
    }

    public Double sum (Double a) {
        return weight + a;
    }
}
