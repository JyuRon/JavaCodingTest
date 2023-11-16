package com.boj_150.h_ShortestPath.Level4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q03_13549 {
    static FastReader sc = new FastReader();
    static int n, m;
    static int[] distance, dir = {1,-1,2};
    static void input(){
        n = sc.nextInt();
        m = sc.nextInt();

        distance = new int[100001];
        Arrays.fill(distance, Integer.MAX_VALUE);
    }

    static void func(){
        dijk();
        System.out.println(distance[m]);
    }

    static void dijk(){
        Queue<Info> Q = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
        distance[n] = 0;
        Q.add(new Info(n,0));

        while (!Q.isEmpty()){
            Info current = Q.poll();

            if(current.value > distance[current.index]) continue;

            for (int i = 0; i < 3; i++) {
                int next = current.index;
                int d = distance[current.index];

                if(i == 2){
                    next *= dir[i];
                }else{
                    next += dir[i];
                    d++;
                }



                // 범위를 벗어나는 경우
                if(next < 0 || next >= 100001) continue;
                if(distance[next] <= d) continue;

                distance[next] = d;
                Q.add(new Info(next, d));
            }
        }

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
