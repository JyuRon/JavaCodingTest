package com.ndb_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/21924
 */
public class Q07_21924 {
    static FastReader sc = new FastReader();
    static int N, M;
    static Queue<Edge> Q = new PriorityQueue<>();
    static long total;
    static int[] parent, rank;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        parent = new int[N+1];
        rank = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
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
            Edge current = Q.poll();

            if(find(current.left) != find(current.right)){
                union(current.left, current.right);
                tmp += current.value;
            }
        }

        for (int i = 2; i <= N ; i++) {
            if(find(1) != find(i)){
                System.out.println(-1);
                return;
            }
        }

        System.out.println(total - tmp);
    }

    static int find(int value){

        if(parent[value] != value){
            parent[value] = find(parent[value]);
        }
        return parent[value];
    }

    static void union(int left, int right){
        int root1 = find(left);
        int root2 = find(right);

        if(rank[root1] > rank[root2]){
            parent[root2] = root1;
        }else{
            parent[root1] = root2;
            if(rank[root1] == rank[root2]){
                rank[root2]++;
            }
        }
    }


    public static void main(String[] args) {
        input();
        func();
    }

    static class Edge implements Comparable<Edge>{
        int left;
        int right;
        long value;
        public Edge(int left, int right, long value){
            this.left = left;
            this.right = right;
            this.value = value;
        }

        @Override
        public int compareTo(Edge other){
            if(this.value - other.value < 0){
                return -1;
            }else if(this.value == other.value){
                return 0;
            }else{
                return 1;
            }
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
