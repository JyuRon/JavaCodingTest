package com.example.b_Algorithm;

import java.util.*;

/**
 * 최소 신장 알고리즘 : 최소한의 비용으로 모든 간선을 연결
 * 시간복잡도 : ElogE (E : 간선 수)
 */
public class Section14_Kruskal {

    Map<String, String> parent = new HashMap<>();
    Map<String, Integer> rank = new HashMap<>();

    // compression 기법
    public String find(String node){

        if(parent.get(node) != node){
            parent.put(node, find(parent.get(node)));
        }

        return parent.get(node);
    }

    // union-by-rank 기법
    public void union(String nodeU, String nodeV){

        String root1 = find(nodeU);
        String root2 = find(nodeV);

        if(rank.get(root1) > rank.get(root2)){
            parent.put(root2, root1);
        }else{
            parent.put(root1, root2);
            if(rank.get(root1) == rank.get(root2)){
                rank.put(root2, rank.get(root2) + 1);
            }
        }

    }

    public List<EdgeMST> kruskalFunc(List<String> vetices, List<EdgeMST> edges){

        List<EdgeMST> mst = new ArrayList<>();

        // 초기화
        for(String vertex : vetices){
            rank.put(vertex, 0);
            parent.put(vertex, vertex);
        }

        // 간선 비용순 오름차순 정렬
        Collections.sort(edges);

        for(EdgeMST edge : edges){
            if(find(edge.nodeU) != find(edge.nodeV)){
                union(edge.nodeU, edge.nodeV);
                mst.add(edge);
            }
        }

        return mst;
    }


    public static void main(String[] args) {
        List<String> vetices = new ArrayList<>(List.of("A", "B", "C", "D", "E", "F", "G"));
        List<EdgeMST> edges = new ArrayList<>();
        edges.add(new EdgeMST(7, "A", "B"));
        edges.add(new EdgeMST(5, "A", "D"));
        edges.add(new EdgeMST(7, "B", "A"));
        edges.add(new EdgeMST(8, "B", "C"));
        edges.add(new EdgeMST(9, "B", "D"));
        edges.add(new EdgeMST(7, "B", "E"));
        edges.add(new EdgeMST(8, "C", "B"));
        edges.add(new EdgeMST(5, "C", "E"));
        edges.add(new EdgeMST(5, "D", "A"));
        edges.add(new EdgeMST(9, "D", "B"));
        edges.add(new EdgeMST(7, "D", "E"));
        edges.add(new EdgeMST(6, "D", "F"));
        edges.add(new EdgeMST(7, "E", "B"));
        edges.add(new EdgeMST(5, "E", "C"));
        edges.add(new EdgeMST(7, "E", "D"));
        edges.add(new EdgeMST(8, "E", "F"));
        edges.add(new EdgeMST(9, "E", "G"));
        edges.add(new EdgeMST(6, "F", "D"));
        edges.add(new EdgeMST(8, "F", "E"));
        edges.add(new EdgeMST(11, "F", "G"));
        edges.add(new EdgeMST(9, "G", "E"));
        edges.add(new EdgeMST(11, "G", "F"));

        Collections.sort(edges);


        Section14_Kruskal kruskal = new Section14_Kruskal();

        for (EdgeMST edge : kruskal.kruskalFunc(vetices, edges)){
            System.out.println(edge);
        }
    }
}
