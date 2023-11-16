package com.boj_150.h_ShortestPath.Level4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q05_1916 {
    static FastReader sc = new FastReader();
    static int N, M, start, end;
    static int[] distance;
    static List<Info>[] graph;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        distance = new int[N+1];
        graph = new ArrayList[N+1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 1; i <= N ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();

            graph[start].add(new Info(end, value));
        }

        start = sc.nextInt();
        end = sc.nextInt();
    }

    static void func(){
        Queue<Info> Q = new LinkedList<>();
        distance[start] = 0;
        Q.add(new Info(start, 0));

        while (!Q.isEmpty()){
            Info current = Q.poll();

            if(current.value > distance[current.index]) continue;

            for(Info next : graph[current.index]){
                int t = current.value + next.value;

                if(t >= distance[next.index]) continue;

                distance[next.index] = t;
                Q.add(new Info(next.index, t));
            }
        }

        System.out.println(distance[end]);
    }

    public static void main(String[] args) {
        input();
        func();
    }


    static class Info{
        int index;
        int value;
        public Info(int index, int value){
            this.index = index;
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
