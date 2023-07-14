package com.example.g_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2644
 */
public class Q16_2644 {

    static FastReader sc = new FastReader();
    static int N, startNode, endNode, edges;
    static int[] distance;
    static Map<Integer, List<Integer>> graph = new HashMap<>();

    static void input(){
        N = sc.nextInt();
        startNode = sc.nextInt();
        endNode = sc.nextInt();
        edges = sc.nextInt();

        distance = new int[N+1];

        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
            distance[i] = -1;
        }

        for (int i = 0; i < edges; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }

    static void func(){
        Queue<Integer> Q = new LinkedList<>();
        Q.add(startNode);
        distance[startNode] = 0;

        while (!Q.isEmpty()){
            int currentNode = Q.poll();

            for (int i = 0; i < graph.get(currentNode).size(); i++) {
                if(distance[graph.get(currentNode).get(i)] == -1){
                    distance[graph.get(currentNode).get(i)] = distance[currentNode] + 1;
                    Q.add(graph.get(currentNode).get(i));
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        func();
        System.out.println(distance[endNode]);
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next(){
            try{
                while (st == null || !st.hasMoreElements()){
                    st = new StringTokenizer(br.readLine());
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            return st.nextToken();
        }

        public int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
