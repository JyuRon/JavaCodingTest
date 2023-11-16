package com.boj_150.h_ShortestPath.Level4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
public class Q07_21924 {
    static FastReader sc = new FastReader();
    static int N,M;
    static long total;
    static int[] parent, rank;
    static Queue<Edge> Q;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        Q = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));

        parent = new int[N+1];
        rank = new int[N+1];

        for (int i = 1; i <= N ; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();

            total += value;
            Q.add(new Edge(start, end, value));

        }
    }

    static void func(){
        long tmp = 0;

        while (!Q.isEmpty()){
            Edge edge = Q.poll();

            // union-find
            if(find(edge.x) != find(edge.y)){
                union(edge.x, edge.y);
                tmp += edge.value;
            }
        }

        for (int i = 2; i <= N ; i++) {
            if(find(parent[1]) != find(parent[i])){
                System.out.println(-1);
                return;
            }
        }

        System.out.println(total - tmp);
    }

    static void union(int x, int y){
        int root1 = find(x);
        int root2 = find(y);

        if(rank[root1] > rank[root2]){
            parent[root2] = root1;
        }else{
            parent[root1] = root2;

            if(rank[root1] == rank[root2]){
                rank[root2]++;
            }
        }
    }

    static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void main(String[] args) {
        input();
        func();
    }

    static class Edge{
        int x;
        int y;
        int value;
        public Edge(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
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
