package com.boj_150.e_Graph.Level2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q02_2606 {
    static FastReader sc = new FastReader();
    static boolean[] visited;
    static int N,M;
    static List<Integer>[] graph;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N+1];
        graph = new ArrayList[N+1];

        for (int i = 1; i <= N ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            graph[start].add(end);
            graph[end].add(start);
        }
    }

    static void bfs(){
        int count = 0;
        Queue<Integer> Q = new LinkedList<>();
        Q.add(1);
        visited[1] =true;

        while (!Q.isEmpty()){
            int current = Q.poll();

            for(int next : graph[current]){
                if(visited[next]){
                    continue;
                }

                count++;
                visited[next] = true;
                Q.add(next);
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        input();
        bfs();
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
