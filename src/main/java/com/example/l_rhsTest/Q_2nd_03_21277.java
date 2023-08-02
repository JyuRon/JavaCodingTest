package com.example.l_rhsTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/21277
 */
public class Q_2nd_03_21277 {
    static FastReader sc = new FastReader();
    static int N1, M1, N2, M2;
    static int[][] A, B, rightB, leftB, halfB, check;
    static int result = Integer.MAX_VALUE;
    static List<int[][]> list = new ArrayList<>();
    static void input(){
        N1 = sc.nextInt();
        M1 = sc.nextInt();
        A = new int[N1][M1];
        for (int i = 0; i < N1; i++) {
            String value = sc.next();
            for (int j = 0; j < M1; j++) {
                A[i][j] = Integer.parseInt(String.valueOf(value.charAt(j)));
            }
        }

        N2 = sc.nextInt();
        M2 = sc.nextInt();
        B = new int[N2][M2];
        for (int i = 0; i < N2; i++) {
            String value = sc.next();
            for (int j = 0; j < M2; j++) {
                B[i][j] = Integer.parseInt(String.valueOf(value.charAt(j)));
            }
        }
        initCheckArray();
        rightB = turnArray(B);
        halfB = turnArray(rightB);
        leftB = turnArray(halfB);

        list.add(rightB);
        list.add(halfB);
        list.add(leftB);
        list.add(B);

    }
    static void func(){
        for (int i = 0; i <= 101; i++) {
            for (int j = 0; j <= 101; j++) {
                for(int[][] current : list){
                    if(checkAvailable(i,j,current)){
                        result = Math.min(result, calc());
                    }
                    initCheckArray();
                }

            }
        }
    }

    static boolean checkAvailable(int row, int col, int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if(array[i][j] == 1 && check[row+i][col+j] != 0){
                    return false;
                }

                if(array[i][j] == 1){
                    check[row+i][col+j] = 2;
                }

            }
        }
        return true;
    }

    static void initCheckArray(){
        check = new int[150][150];
        for (int i = 0; i < N1; i++) {
            for (int j = 0; j < M1; j++) {
                check[i+50][j+50] = A[i][j];
            }
        }
    }

    static int calc(){
        int bottomCol = 100;
        int bottomRow = 100;
        int topCol = -1;
        int topRow = -1;
        for (int i = 0; i < check.length; i++) {
            for (int j = 0; j < check[0].length; j++) {
                if(check[i][j] != 0){
                    bottomRow = Math.min(i, bottomRow);
                    topRow = Math.max(i, topRow);
                    bottomCol = Math.min(j,bottomCol);
                    topCol = Math.max(j, topCol);
                }
            }
        }

        return (topCol - bottomCol + 1) * (topRow - bottomRow + 1);
    }

    static int[][] turnArray(int[][] array){
        int row = array.length;
        int col = array[0].length;
        int[][] turn = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                turn[j][row-1-i] = array[i][j];
            }
        }

        return turn;
    }



    public static void main(String[] args) {
        input();
        func();
        System.out.println(result);
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
