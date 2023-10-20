package com.boj_150.e_Graph.Level2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q04_11724 {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int N = sc.nextInt();
        int M = sc.nextInt();
        boolean[] visited = new boolean[N+1];
        boolean[] check = new boolean[N+1];

        List<Integer>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            graph[start].add(end);
            graph[end].add(start);
        }

        int count = 0;
        for (int i = 1; i <= N ; i++) {
            if(!visited[i]){
                count++;

                Queue<Integer> Q = new LinkedList<>();
                Q.add(i);
                visited[i] = true;

                while (!Q.isEmpty()){
                    int current = Q.poll();

                    for(int next : graph[current]){
                        // 이미 방문한 이력이 있는 경우
                        if(visited[next]) continue;;

                        Q.add(next);
                        visited[next] = true;
                    }
                }
            }
        }

        System.out.println(count);
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
