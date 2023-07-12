package com.example.g_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q13_11403 {

    static FastReader sc = new FastReader();
    static int N;
    static boolean[] visited;
    static Map<Integer, List<Integer>> graph;
    static StringBuffer sb = new StringBuffer();

    static void input(){
        N = sc.nextInt();
        visited = new boolean[N];

        graph = new HashMap<>();

        for (int i = 0; i < N; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                int value = sc.nextInt();
                if(value == 1){
                    tmp.add(j);
                }
            }
            graph.put(i, tmp);
        }

    }

    static void func(){
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            bfs(i);
            for (int j = 0; j < N; j++) {
                if(visited[j]){
                    sb.append(1).append(" ");
                }else{
                    sb.append(0).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static void bfs(int value){
        Queue<Integer> Q = new LinkedList<>();
        Q.add(value);


        while (!Q.isEmpty()){
            int current = Q.poll();
            for (int i = 0; i < graph.get(current).size(); i++) {
                if(!visited[graph.get(current).get(i)]){
                    Q.add(graph.get(current).get(i));
                    visited[graph.get(current).get(i)] = true;
                }
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
