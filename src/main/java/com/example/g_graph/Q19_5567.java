package com.example.g_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/5567
 */
public class Q19_5567 {

    static FastReader sc = new FastReader();
    static int N, edges;
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static int[] distance;

    static void input(){
        N = sc.nextInt();
        edges = sc.nextInt();
        distance = new int[N+1];

        for (int i = 1; i <= N ; i++) {
            distance[i] = -1;
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
        Queue<Integer> Q = new LinkedList<>();
        Q.add(1);
        distance[1] = 0;

        while (!Q.isEmpty()){
            int current = Q.poll();

            for (int i = 0; i < graph.get(current).size(); i++) {
                if(distance[graph.get(current).get(i)] == -1){
                    distance[graph.get(current).get(i)] = distance[current] + 1;
                    Q.add(graph.get(current).get(i));
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= N ; i++) {
            if(distance[i] <= 2 && distance[i] >= 1){
                count++;
            }
        }

        System.out.println(count);
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
