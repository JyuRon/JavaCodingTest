package com.example.g_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/11725
 */
public class Q14_11725 {

    static FastReader  sc = new FastReader();
    static int N;
    static int[] result;
    static boolean[] visited;
    static Map<Integer, List<Integer>> graph = new HashMap<>();

    static void input(){
        N = sc.nextInt();
        visited = new boolean[N+1];
        result = new int[N+1];

        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();

            graph.get(startNode).add(endNode);
            graph.get(endNode).add(startNode);
        }
    }

    static void func(){
        Queue<Integer> Q = new LinkedList<>();
        Q.add(1);
        visited[1] = true;

        while (!Q.isEmpty()){
            int current = Q.poll();
            for (int i = 0; i < graph.get(current).size(); i++) {
                if(!visited[graph.get(current).get(i)]){
                    Q.add(graph.get(current).get(i));
                    visited[graph.get(current).get(i)] = true;
                    result[graph.get(current).get(i)] = current;
                }
            }
        }

        for (int i = 2; i <= N ; i++) {
            System.out.println(result[i]);
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
