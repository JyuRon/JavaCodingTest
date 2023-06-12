package com.example.b_Algorithm;

import java.util.*;

public class Section15_Prim {

    public List<EdgeMST> primFunc(String startNode, List<EdgeMST> edges){
        List<EdgeMST> mst = new ArrayList<>();


        // 인접 노드 정보 초기화 (공간만 할당)
        Map<String, List<EdgeMST>> adjacentEdges = new HashMap<>();
        for(EdgeMST edge : edges){
            if (!adjacentEdges.containsKey(edge.nodeV)) {
                adjacentEdges.put(edge.nodeV, new ArrayList<>());
            }
            if (!adjacentEdges.containsKey(edge.nodeU)) {
                adjacentEdges.put(edge.nodeU, new ArrayList<>());
            }
        }

        // 인접 노드 정보 삽입
        for(EdgeMST edge : edges){
            List<EdgeMST> currentEdgeList = adjacentEdges.get(edge.nodeV);
            currentEdgeList.add(new EdgeMST(edge.weight, edge.nodeV, edge.nodeU));

            currentEdgeList = adjacentEdges.get(edge.nodeU);
            currentEdgeList.add(new EdgeMST(edge.weight, edge.nodeU, edge.nodeV));
        }


        // 연결된 노드를 저장할 리스트 정의
        List<String> connectedNodes = new ArrayList<>();
        connectedNodes.add(startNode);


        // 시작 노드와 연결된 정점들 정보 우선순위 큐에 삽입
        List<EdgeMST> candidateEdgeList = adjacentEdges.getOrDefault(startNode, new ArrayList<>());
        PriorityQueue<EdgeMST> priorityQueue = new PriorityQueue<>();
        priorityQueue.addAll(candidateEdgeList);


        while (priorityQueue.size() > 0) {
            EdgeMST poppedEdge = priorityQueue.remove();

            // 도착지점의 정점이 이미 연결되어 있는지 파악
            if (!connectedNodes.contains(poppedEdge.nodeU)) {
                connectedNodes.add(poppedEdge.nodeU);
                mst.add(new EdgeMST(poppedEdge.weight, poppedEdge.nodeV, poppedEdge.nodeU));


                // 도착지점과 연결된 정점 정보를 가지고 이미 연결된 정점의 경우 추가 하지 않음
                List<EdgeMST> adjacentEdgeNodes = adjacentEdges.getOrDefault(poppedEdge.nodeU, new ArrayList<>());
                for(EdgeMST edge : adjacentEdgeNodes){
                    if(!connectedNodes.contains(edge.nodeU)) {
                        priorityQueue.add(edge);
                    }
                }
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        List<EdgeMST> myedges = new ArrayList<>();
        myedges.add(new EdgeMST(7, "A", "B"));
        myedges.add(new EdgeMST(5, "A", "D"));
        myedges.add(new EdgeMST(8, "B", "C"));
        myedges.add(new EdgeMST(9, "B", "D"));
        myedges.add(new EdgeMST(7, "D", "E"));
        myedges.add(new EdgeMST(5, "C", "E"));
        myedges.add(new EdgeMST(7, "B", "E"));
        myedges.add(new EdgeMST(6, "D", "F"));
        myedges.add(new EdgeMST(8, "E", "F"));
        myedges.add(new EdgeMST(9, "E", "G"));
        myedges.add(new EdgeMST(11, "F", "G"));

        Section15_Prim prim = new Section15_Prim();
        for (EdgeMST edge : prim.primFunc("A", myedges)){
            System.out.println(edge);
        }

    }
}
