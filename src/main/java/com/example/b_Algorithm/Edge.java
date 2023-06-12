package com.example.b_Algorithm;

public class Edge implements Comparable<Edge>{

    public double distance;
    public String vertex;

    public Edge() {
    }

    public Edge(double distance, String vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }

    @Override
    public int compareTo(Edge o) {
        return (int)(this.distance - o.distance);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "distance=" + distance +
                ", vertex='" + vertex + '\'' +
                '}';
    }
}
