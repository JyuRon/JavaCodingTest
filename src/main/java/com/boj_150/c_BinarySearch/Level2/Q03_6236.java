package com.boj_150.c_BinarySearch.Level2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Q03_6236 {
    static FastReader sc = new FastReader();
    static int N, M;
    static int[] money;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        money = new int[N];

        for (int i = 0; i < N; i++) {
            money[i] = sc.nextInt();
        }

    }

    static void func(){
        int bottom = 1;
        int top = 1000000000;
        int result = 0;

        for (int i = 0; i < N; i++) {
            bottom = Math.max(bottom, money[i]);
        }

        while (bottom <= top){
            int mid = (bottom + top) / 2;

            if(solve(mid)){
                top = mid - 1;
                result = mid;
            }else{
                bottom = mid + 1;
            }
        }

        System.out.println(result);
    }

    static boolean solve(int value){
        int count = 0;
        int currentMoney = 0;

        for (int i = 0; i < N; i++) {
            int target = money[i];

            if(currentMoney < target){
                count++;
                currentMoney = value;
            }

            currentMoney -= target;
        }

        return count <= M;
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
