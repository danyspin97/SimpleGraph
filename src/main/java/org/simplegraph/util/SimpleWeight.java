package org.simplegraph.util;

import org.simplegraph.Weight;
import org.simplegraph.Summable;

public class SimpleWeight implements Weight<Double>, Summable<Double> {
    Double weight;

    public SimpleWeight() {
        weight = 0.d;
    }

    public SimpleWeight(double d) {
        weight = d;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double d) {
        weight = d;
    }

    public boolean isInf() {
        return Double.POSITIVE_INFINITY == weight;
    }

    public Double sum (Double a) {
        if (a == null) {
            return weight;
        }

        return weight + a;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        SimpleWeight s = (SimpleWeight) o;

        return weight.equals(s.weight);
    }
}
