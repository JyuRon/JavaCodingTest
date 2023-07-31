package com.example.l_rhsTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/20165
 */
public class Q_1st_02_20165 {
    static FastReader sc = new FastReader();
    static StringBuffer sb = new StringBuffer();
    static int N,M,R;
    static int[][] value, direction = {{0,1},{0,-1},{1,0},{-1,0}};
    static char[][] result;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();;
        R = sc.nextInt();

        value = new int[N+1][M+1];
        result = new char[N+1][M+1];

        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= M ; j++) {
                value[i][j] = sc.nextInt();
                result[i][j] = 'S';
            }
        }
    }

    static int func(int row, int col, String dir){
        int count = 0;

        int nextRowDir = 0;
        int nextColDir = 0;

        if(dir.equals("E")){
            nextRowDir = direction[0][0];
            nextColDir = direction[0][1];
        }else if(dir.equals("W")){
            nextRowDir = direction[1][0];
            nextColDir = direction[1][1];
        }else if(dir.equals("S")){
            nextRowDir = direction[2][0];
            nextColDir = direction[2][1];
        }else if (dir.equals("N")) {
            nextRowDir = direction[3][0];
            nextColDir = direction[3][1];
        }

        int height = value[row][col];
        int nextRow = row;
        int nextCol = col;
        while (height > 0){

            // 공간을 벗어나는 경우
            if(nextRow < 1 || nextRow > N || nextCol < 1 || nextCol > M){
                break;
            }


            if(result[nextRow][nextCol] == 'S'){
                result[nextRow][nextCol] = 'F';
                count++;
                height = Math.max(height, value[nextRow][nextCol]);
            }


            height--;
            nextRow += nextRowDir;
            nextCol += nextColDir;
        }

        return count;
    }
    static void rec(int row, int col){
        result[row][col] = 'S';
    }

    public static void main(String[] args) {
        input();
        int ans = 0;
        for (int i = 0; i < R; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            String dir = sc.next();
            if(result[row][col] == 'S'){
                ans += func(row, col, dir);
            }

            row = sc.nextInt();
            col = sc.nextInt();
            rec(row, col);
        }

        System.out.println(ans);
        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= M ; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
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
