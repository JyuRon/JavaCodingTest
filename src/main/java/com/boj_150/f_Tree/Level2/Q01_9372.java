package com.boj_150.f_Tree.Level2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class Q01_9372 {
    static FastReader sc = new FastReader();
    static int T,N,M,result;
    static List<Integer>[] graph;
    static boolean[] visited;

    static void input(){
        result = 0;
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

        dfs(1);
        System.out.println(result);
    }


    static void dfs(int value){
        visited[value] = true;


        for(int next : graph[value]){
            if(visited[next]) continue;
            result++;
            dfs(next);

        }
    }

    public static void main(String[] args) {
        T = sc.nextInt();
        while (T-- > 0){
            input();
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
