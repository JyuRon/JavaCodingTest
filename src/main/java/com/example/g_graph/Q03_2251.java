package com.example.g_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2251
 */
public class Q03_2251 {

    static FastReader sc = new FastReader();
    static StringBuffer sb = new StringBuffer();
    static int aCapacity,bCapacity,cCapacity;
    static boolean[][][] visited;
    static List<Integer> result = new ArrayList<>();

    static void input(){
        aCapacity = sc.nextInt();
        bCapacity = sc.nextInt();
        cCapacity = sc.nextInt();

        visited = new boolean[aCapacity + 1][bCapacity + 1][cCapacity + 1];
    }

    static void func(){
        dfs(0,0,cCapacity);
        Collections.sort(result);
        for(int i : result){
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }

    static void dfs(int a, int b, int c){
        if(!visited[a][b][c]){
            if(a == 0){
                result.add(c);
            }
            visited[a][b][c] = true;


            int over = 0;

            // a -> b
            // 물을 모두 옮기는 경우
            if(a+b <= bCapacity){
                dfs(0, a+b, c);

                // 물의 일부만 옮겨 다른 물통이 가득 찬 경우
            }else{
                over = a + b - bCapacity;
                dfs(over, bCapacity, c);
            }

            // a -> c
            if(a+b <= cCapacity){
                dfs(0, b, a+c);
            }else{
                over = a + c - cCapacity;
                dfs(over, b, cCapacity);
            }

            // b -> a
            if(a+b <= aCapacity){
                dfs(a+b, 0, c);
            }else{
                over = a + b - aCapacity;
                dfs(aCapacity, over, c);
            }

            // b -> c
            if(b+c <= cCapacity){
                dfs(a, 0, b+c);
            }else{
                over = b + c - cCapacity;
                dfs(a, over, cCapacity);
            }

            // c -> a
            if(c+a <= aCapacity){
                dfs(a+c, b, 0);
            }else{
                over = c + a - aCapacity;
                dfs(aCapacity, b, over);
            }

            // c -> b
            if(c+b <= bCapacity){
                dfs(a, c+b, 0);
            }else{
                over = c + b - bCapacity;
                dfs(a, bCapacity, over);
            }
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
