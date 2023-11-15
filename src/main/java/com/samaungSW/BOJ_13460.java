package com.samaungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13460 {
    static FastReader sc = new FastReader();
    static int N,M;
    static String[] graph;
    static int[][][] distance;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static int redX, redY, blueX, blueY, holeX, holeY;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new String[N];

        for (int i = 0; i < N; i++) {
            graph[i] = sc.nextLine();

            for (int j = 0; j < M; j++) {
                if(graph[i].charAt(j) == 'R'){
                    redX = i; redY = j;
                } else if (graph[i].charAt(j) == 'B') {
                    blueX = i; blueY = j;
                }else if(graph[i].charAt(j) == 'O'){
                    holeX = i; holeY = j;
                }
            }
        }

        distance = new int[N][M][2];
    }

    static void bfs(){
        Queue<Integer> Q = new LinkedList<>();
        Q.add(redX); Q.add(redY);
        Q.add(blueX); Q.add(blueY);

        while (!Q.isEmpty()){
            int rX = Q.poll();
            int rY = Q.poll();

            int bX = Q.poll();
            int bY = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nextRx = rX; int nextRy = rY;
                int nextBx = bX; int nextBy = bY;

                boolean blueCheck = false;
                boolean redCheck = false;

                while (graph[nextRx + dir[i][0]].charAt(nextRy + dir[i][1]) != '#'){
                    nextRx += dir[i][0];
                    nextRy += dir[i][1];

                    if(nextRx == holeX && nextRy == holeY){
                        redCheck = true;
                        break;
                    }
                }
            }
        }

        int result = distance[holeX][holeY][0];

        if(result > 10 || result == 0){
            result = -1;
        }

        System.out.println(result);
    }




    public static void main(String[] args) {
        input();
        bfs();
    }

    static class FastReader {
            BufferedReader br;
            StringTokenizer st;

            public FastReader() {
                br = new BufferedReader(new InputStreamReader(System.in));
            }

            public String next() {
                try {
                    while (st == null || !st.hasMoreElements()) {
                        st = new StringTokenizer(br.readLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return st.nextToken();
            }

            public int nextInt() {
                return Integer.parseInt(next());
            }

            public long nextLong(){
                return Long.parseLong(next());
            }

        public String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
        }
}
