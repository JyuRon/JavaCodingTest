package com.boj_150.a_BruteForce.Level3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Q01_1051 {
    static FastReader sc = new FastReader();
    static int N, M, result;
    static String[] graph;
    static int[][] dir = {{1,1}, {1,0},{0,1}};

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new String[N];

        for (int i = 0; i < N; i++) {
            graph[i] = sc.nextLine();
        }
    }

    static void func(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int length = 1;

                while (length <= Math.min(N,M)){
                    areaCheck(i,j,graph[i].charAt(j), length);
                    length++;
                }
            }
        }

        System.out.println(result);
    }


    static void areaCheck(int x, int y, char target, int length){

        for (int i = 0; i < 3; i++) {
            int nextX = x + dir[i][0] * (length - 1);
            int nextY = y + dir[i][1] * (length - 1);

            // 범위를 벗어나는 경우
            if(nextX >= N || nextY >= M){
                return;
            }

            // 꼭짓점의 값이 일치하지 않는 경우
            if(target != graph[nextX].charAt(nextY)){
                return;
            }
        }

        result = Math.max(result, length * length);
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

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        }
}
