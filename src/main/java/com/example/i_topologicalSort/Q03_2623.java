package com.example.i_topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2623
 */
public class Q03_2623 {
    static FastReader sc = new FastReader();
    static StringBuffer sb = new StringBuffer();
    static int N,M;
    static ArrayList<Integer>[] graph;
    static int[] inDegree;
    static boolean[] visited;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        inDegree = new int[N+1];
        visited = new boolean[N+1];
        graph = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int loop = sc.nextInt();
            if(loop >= 2){
                int startNode = sc.nextInt();
                for (int j = 0; j < loop-1; j++) {
                    int endNode = sc.nextInt();
                    graph[startNode].add(endNode);
                    inDegree[endNode]++;
                    startNode = endNode;
                }
            }

        }
    }

    static void func(){
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 1; i <= N ; i++) {
            if(inDegree[i] == 0){
                Q.add(i);
            }
        }

        if(Q.size() == 0){
            System.out.println(0);
            return;
        }

        while (!Q.isEmpty()){
            int current = Q.poll();
            visited[current] = true;
            sb.append(current).append("\n");

            for(int next : graph[current]){
                inDegree[next]--;

                if(inDegree[next] == 0){
                    Q.add(next);
                }
            }
        }

        // 사이클이 생기는 경우 모든 정점을 방문 할 수 없다
        for (int i = 1; i <= N ; i++) {
            if(!visited[i]){
                System.out.println(0);
                return;
            }
        }

        System.out.println(sb.toString());
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
