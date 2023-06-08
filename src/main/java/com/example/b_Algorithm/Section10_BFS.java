package com.example.b_Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 시간 복잡도 : V(노드) + E(간선)
 * FIFO
 */
public class Section10_BFS {

    public List<String> search(Map<String, List<String>> graph, String startNode){

        List<String> needVisit = new ArrayList<>();
        List<String> visited = new ArrayList<>();

        needVisit.add(startNode);

        while (needVisit.size() > 0){
            String node = needVisit.remove(0);

            if(!visited.contains(node)){
                visited.add(node);
                needVisit.addAll(graph.get(node));
            }

        }
        return visited;
    }


    public static void main(String[] args) {
        Section10_BFS bfs = new Section10_BFS();
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", List.of("B","C"));
        graph.put("B", List.of("A","D"));
        graph.put("C", List.of("A","G","H","I"));
        graph.put("D", List.of("B","E","F"));
        graph.put("E", List.of("D"));
        graph.put("F", List.of("D"));
        graph.put("G", List.of("C"));
        graph.put("H", List.of("C"));
        graph.put("I", List.of("C","J"));
        graph.put("J", List.of("I"));

        System.out.println(bfs.search(graph,"A"));

    }
}
