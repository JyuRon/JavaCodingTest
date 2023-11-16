package com.boj_150.g_TopologicalSort.Level4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Q01_1516 {
    static FastReader sc = new FastReader();
    static int[] inDegree, Dy, ori;
    static List<Integer>[] graph;
    static int N;
    static void input(){
        N = sc.nextInt();
        inDegree = new int[N+1];
        Dy = new int[N+1];
        ori = new int[N+1];
        graph = new ArrayList[N+1];

        for (int i = 1; i <= N ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N ; i++) {
            int time = sc.nextInt();
            int before = sc.nextInt();

            ori[i] = time;

            while (before != -1){
                inDegree[i]++;
                graph[before].add(i);
                before = sc.nextInt();
            }
        }
    }

    static void func(){
        Queue<Integer> Q = new LinkedList<>();


        for (int i = 1; i <= N; i++) {
            if(inDegree[i] == 0){
                Q.add(i);
                Dy[i] = ori[i];
            }

        }

        while (!Q.isEmpty()){
            int current = Q.poll();

            for(int next : graph[current]){
                inDegree[next]--;
                Dy[next] = Math.max(Dy[next], ori[next] + Dy[current]);

                if(inDegree[next] == 0){
                    Q.add(next);
                }
            }
        }

        for (int i = 1; i <= N ; i++) {
            System.out.println(Dy[i]);
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
