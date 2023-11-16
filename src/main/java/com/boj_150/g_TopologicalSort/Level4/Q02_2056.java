package com.boj_150.g_TopologicalSort.Level4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q02_2056 {
    static FastReader sc = new FastReader();
    static int N;
    static int[] inDegree, time, Dy;
    static List<Integer>[] graph;
    static void input(){
        N = sc.nextInt();

        inDegree = new int[N+1];
        time = new int[N+1];
        Dy = new int[N+1];
        graph = new ArrayList[N+1];

        for (int i = 1; i <= N ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N ; i++) {
            int t = sc.nextInt();
            int m = sc.nextInt();

            time[i] = t;
            inDegree[i] = m;

            while (m-- > 0){
                int before = sc.nextInt();
                graph[before].add(i);
            }
        }
    }

    static void func(){
        int result = 0;

        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= N ; i++) {
            if(inDegree[i] == 0){
                Q.add(i);
                Dy[i] = time[i];
            }
        }

        while (!Q.isEmpty()){
            int current = Q.poll();
            result = Math.max(result,Dy[current]);

            for(int next : graph[current]){
                inDegree[next]--;
                Dy[next] = Math.max(Dy[next], Dy[current] + time[next]);

                if(inDegree[next] == 0)
                    Q.add(next);
            }
        }

        System.out.println(result);
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
