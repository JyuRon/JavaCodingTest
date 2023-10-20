package com.boj_150.e_Graph.Level2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q01_1260 {
    static FastReader sc = new FastReader();
    static StringBuffer sb = new StringBuffer();
    static List<Integer>[] graph;
    static boolean[] visited;
    static int N,M;
    public static void main(String[] args) {
        N = sc.nextInt();
        M = sc.nextInt();

        int root = sc.nextInt();

        graph = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            graph[start].add(end);
            graph[end].add(start);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N+1];
        dfs(root);
        sb.append("\n");
        bfs(root);
        System.out.println(sb.toString());

    }

    static void dfs(int value){
        visited[value] = true;
        sb.append(value).append(" ");

        for(int i : graph[value]){
            if(visited[i])
                continue;

            dfs(i);
        }
    }

    static void bfs(int start){
        visited = new boolean[N+1];
        Queue<Integer> Q = new LinkedList<>();
        Q.add(start);
        visited[start] = true;
        sb.append(start).append(" ");

        while (!Q.isEmpty()){
            int current = Q.poll();

            for(int i : graph[current]){
                if(visited[i]) continue;

                Q.add(i);
                visited[i] = true;
                sb.append(i).append(" ");
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
