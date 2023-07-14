package com.example.g_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1389
 */
public class Q18_1389 {
    static FastReader sc = new FastReader();
    static int N, edges;
    static int[] distance;
    static boolean[]visited;
    static int result = Integer.MAX_VALUE;
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static int resultNode;

    static void input(){
        N = sc.nextInt();
        edges = sc.nextInt();


        for (int i = 1; i <= N ; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges; i++) {
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();

            graph.get(startNode).add(endNode);
            graph.get(endNode).add(startNode);
        }
    }

    static void func(){
        for (int i = 1; i <= N ; i++) {
            bfs(i);
        }

        System.out.println(resultNode);
    }

    static void bfs(int value){
        distance = new int[N+1];
        visited = new boolean[N+1];

        Queue<Integer> Q = new LinkedList<>();
        int sum = 0;
        visited[value] = true;
        Q.add(value);

        while (!Q.isEmpty()){
            int current = Q.poll();

            for (int i = 0; i < graph.get(current).size(); i++) {
                if(!visited[graph.get(current).get(i)]){
                    distance[graph.get(current).get(i)] = distance[current] + 1;
                    visited[graph.get(current).get(i)] = true;
                    Q.add(graph.get(current).get(i));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sum += distance[i];
        }

        if(sum < result){
            resultNode = value;
            result = Math.min(result, sum);
        }
    }

    public static void main(String[] args) {
        input();
        func();
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
