package com.example.h_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1240
 */
public class Q09_1240 {
    static FastReader sc = new FastReader();
    static int N,M;
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static int[] distance;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        distance = new int[N+1];

        for (int i = 1; i <= N ; i++) {
            graph.put(i, new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < N-1; i++) {
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();
            int diff = sc.nextInt();

            graph.get(startNode).add(endNode);
            graph.get(startNode).add(diff);

            graph.get(endNode).add(startNode);
            graph.get(endNode).add(diff);
        }
    }

    static void func(){
        for (int i = 0; i < M; i++) {
            int rootNode = sc.nextInt();
            int findNode = sc.nextInt();

            bfs(rootNode, findNode);
        }
    }

    static void bfs(int rootNode, int findNode){
        for (int i = 1; i <= N ; i++) {
            distance[i] = -1;
        }

        Queue<Integer> Q = new LinkedList<>();
        distance[rootNode] = 0;
        Q.add(rootNode);

        while (!Q.isEmpty()){
            int current = Q.poll();

            for (int i = 0; i < graph.get(current).size(); i+=2) {

                if(distance[graph.get(current).get(i)] == -1){
                    Q.add(graph.get(current).get(i));
                    distance[graph.get(current).get(i)] = distance[current] + graph.get(current).get(i+1);
                }
            }
        }

        System.out.println(distance[findNode]);

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
