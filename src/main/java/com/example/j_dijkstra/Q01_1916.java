package com.example.j_dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1916
 */
public class Q01_1916 {
    static FastReader sc = new FastReader();
    static int N,M,S,E;
    static ArrayList<Info>[] graph;
    static long[] dist;

    static class Info{
        int index;
        long value;

        public Info(int index, long value){
            this.index = index;
            this.value = value;
        }
    }

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new ArrayList[N+1];
        dist = new long[N+1];

        for (int i = 1; i <= N ; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Long.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();
            int value = sc.nextInt();

            graph[startNode].add(new Info(endNode, value));
        }

        S = sc.nextInt();
        E = sc.nextInt();
    }

    static void func(){
        Queue<Info> Q = new PriorityQueue<>(Comparator.comparingLong(o -> o.value));
        Q.add(new Info(S,0));
        dist[S] = 0;

        while (!Q.isEmpty()){
            Info current = Q.poll();

            if(current.value > dist[current.index]){
                continue;
            }

            for(Info next : graph[current.index]){
                if(dist[current.index] + next.value < dist[next.index]){
                    dist[next.index] = dist[current.index] + next.value;
                    Q.add(new Info(next.index, dist[current.index] + (next.value)));
                }
            }
        }

        System.out.println(dist[E]);

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
