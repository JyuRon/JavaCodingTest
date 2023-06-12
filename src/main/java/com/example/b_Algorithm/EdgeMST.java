package com.example.b_Algorithm;

public class EdgeMST implements Comparable<EdgeMST>{
    public int weight;
    public String nodeV;
    public String nodeU;

    public EdgeMST(int weight, String nodeV, String nodeU) {
        this.weight = weight;
        this.nodeV = nodeV;
        this.nodeU = nodeU;
    }

    @Override
    public int compareTo(EdgeMST o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "EdgeTwoWay{" +
                "weight=" + weight +
                ", nodeV='" + nodeV + '\'' +
                ", nodeU='" + nodeU + '\'' +
                '}';
    }
}
