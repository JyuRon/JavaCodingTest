package com.example.j_dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1753
 */
public class Q02_1753 {
    static FastReader sc = new FastReader();
    static int V,E,S;
    static int[] dist;
    static ArrayList<Info>[] graph;

    static class Info{
        int index;
        int value;
        public Info(int index, int value){
            this.index = index;
            this.value = value;
        }
    }

    static void input(){
        V = sc.nextInt();
        E = sc.nextInt();
        S = sc.nextInt();
        graph = new ArrayList[V+1];
        dist = new int[V+1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();
            int value = sc.nextInt();

            graph[startNode].add(new Info(endNode, value));
        }
    }

    static void func(){
        Queue<Info> Q = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
        Q.add(new Info(S, 0));
        dist[S] = 0;

        while (!Q.isEmpty()){
            Info current = Q.poll();

            if(current.value > dist[current.index]){
                continue;
            }

            for(Info next : graph[current.index]){
                int nextDistance = dist[current.index] + next.value;

                if(dist[next.index] > nextDistance){
                    dist[next.index] = nextDistance;
                    Q.add(new Info(next.index, nextDistance));
                }
            }
        }

        for (int i = 1; i <= V ; i++) {
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(dist[i]);
            }
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
