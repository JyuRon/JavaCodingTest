package com.boj_150.a_BruteForce.Level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q01_1018 {
    static FastReader sc = new FastReader();
    static String[] graph;
    static int N, M;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new String[N];

        for (int i = 0; i < N; i++) {
            graph[i] = sc.nextLine();
        }
    }

    static void func(){

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {

                // 시작점의 색을 바꾸지 않는 경우
                result = Math.min(result, check(i,j));

                // 시작점의 색을 바꾸는 경우
                result = Math.min(result, check2(i,j));
            }
        }

        System.out.println(result);
    }

    static int check(int x, int y){

        int flag = -99;
        int count = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {

                if(flag == -99){
                    if(graph[i].charAt(j) == 'B'){
                        flag = 1;
                    }else{
                        flag = -1;
                    }

                    continue;
                }

                if(flag == 1 && graph[i].charAt(j) == 'B'){
                    count++;
                }else if(flag == -1 && graph[i].charAt(j) == 'W'){
                    count++;
                }

                flag = flag * -1;
            }

            // 현재줄의 마지막과 다음줄의 처음이 같아야 하기 때문에 트릭으로 -1을 곱한다.
            flag = flag * -1;
        }

        return count;
    }

    static int check2(int x, int y){

        int flag = -99;
        int count = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {

                if(flag == -99){
                    if(graph[i].charAt(j) == 'B'){
                        flag = -1;
                    }else{
                        flag = 1;
                    }

                    count++;

                    continue;
                }

                if(flag == 1 && graph[i].charAt(j) == 'B'){
                    count++;
                }else if(flag == -1 && graph[i].charAt(j) == 'W'){
                    count++;
                }

                flag = flag * -1;
            }

            // 현재줄의 마지막과 다음줄의 처음이 같아야 하기 때문에 트릭으로 -1을 곱한다.
            flag = flag * -1;
        }

        return count;
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

        String nextLine() {
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
