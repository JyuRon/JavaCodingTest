package com.boj_150.g_TopologicalSort.Level4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q03_2611 {
    static FastReader sc = new FastReader();
    static StringBuffer sb = new StringBuffer();
    static int N,M;
    static int[] inDegree, Dy, before, time;
    static List<List<Integer>> graph;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        inDegree = new int[N+1];
        before = new int[N+1];
        Dy = new int[N+1];
        time = new int[N+1];
        graph = new ArrayList<>();

        for (int i = 0; i <= N ; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int t = sc.nextInt();

            inDegree[end]++;
            graph.get(start).add(end);
            time[end] = t;
        }
    }

    static void func(){
        Queue<Integer> Q = new LinkedList<>();
        Q.add(1);

        while (!Q.isEmpty()){
            int current = Q.poll();

            for(int next : graph.get(current)){
                inDegree[next]--;

                if(Dy[next] < Dy[current] + time[next]){
                    Dy[next] =  Dy[current] + time[next];
                    before[next] = current;
                }

                if(next == 1) continue;

                Q.add(next);
            }
        }

        System.out.println(Dy[1]);

        int current = 1;

        List<Integer> result = new ArrayList<>();
        System.out.print(current + " ");

        while (true){
            int next = before[current];
            result.add(next);
            current = next;

            if(current == 1) break;
        }

        for(int i = N-1; i >= 0; i--){
            sb.append(result.get(i)).append(" ");
        }

        System.out.println(sb.toString());

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
