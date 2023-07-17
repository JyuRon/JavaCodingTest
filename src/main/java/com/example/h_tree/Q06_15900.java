package com.example.h_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15900
 */
public class Q06_15900 {
    static FastReader sc = new FastReader();
    static int N, count;
    static int[] distance;
    static ArrayList<Integer>[] graph;

    static void input(){
        N = sc.nextInt();
        graph = new ArrayList[N + 1];
        distance = new int[N+1];

        for (int i = 1; i <= N ; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = -1;
        }

        for (int i = 0; i < N - 1; i++) {
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();

            graph[startNode].add(endNode);
            graph[endNode].add(startNode);
        }
    }

    static void func(){
        bfs();

        if(count % 2 == 0){
            System.out.println("No");
        }else{
            System.out.println("Yes");
        }
    }

    static void bfs(){
        Queue<Integer> Q = new LinkedList<>();
        int rootNode = 1;
        distance[rootNode] = 0;
        Q.add(rootNode);

        while (!Q.isEmpty()){
            int current = Q.poll();

            boolean isLeafNode = true;

            for(int next : graph[current]){
                if(distance[next] == -1){
                    distance[next] = distance[current] + 1;
                    Q.add(next);
                    isLeafNode = false;
                }
            }

            if(isLeafNode){
                count += distance[current];
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
