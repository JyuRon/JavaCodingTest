package com.example.b_Algorithm;

import java.util.*;
import java.util.List;

/**
 * 최단 경로 구현 알고리즘
 * 시간복잡도 : ElogE (E : 간선 수)
 */
public class Section13_Dijkstra {

    public Map<String,Double> getDistance(String startVertex, Map<String, List<Edge>> graph){

        // 결과값 초기화
        Map<String,Double> distance = new HashMap<>();

        for(String vertex: graph.keySet()){
            distance.put(vertex, Double.MAX_VALUE);
        }
        distance.put(startVertex, 0.0);


        // 우선순위 큐 초기화(거리가 짧은 순)
        Queue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(distance.get(startVertex), startVertex));

        // 최단거리 탐색
        while (priorityQueue.size() > 0){
            Edge edge = priorityQueue.remove();
            double currentDistance = edge.distance;
            String currentNode = edge.vertex;

            if(currentDistance > distance.get(currentNode)){
                continue;
            }

            for(Edge adjacent : graph.get(currentNode)){
                double tmpDistance = currentDistance + adjacent.distance;

                if(distance.get(adjacent.vertex) > tmpDistance){
                    distance.put(adjacent.vertex, tmpDistance);
                    priorityQueue.add(new Edge(tmpDistance, adjacent.vertex));
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        Section13_Dijkstra dijkstra = new Section13_Dijkstra();

        Map<String, List<Edge>> graph = new HashMap<>();
        graph.put("A", new ArrayList<>(List.of(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<>(List.of()));
        graph.put("C", new ArrayList<>(List.of(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<>(List.of(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<>(List.of(new Edge(1, "F"))));
        graph.put("F", new ArrayList<>(List.of(new Edge(5, "A"))));


        System.out.println(dijkstra.getDistance("A", graph));
    }
}
