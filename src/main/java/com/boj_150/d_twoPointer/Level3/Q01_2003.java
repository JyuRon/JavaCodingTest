package com.boj_150.d_twoPointer.Level3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Q01_2003 {
    static FastReader sc = new FastReader();
    static int N, M, result;
    static int[] num;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        num = new int[N+1];

        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
    }

    static void func(){
        int left = 0;
        int right = 0;
        int tmp = num[0];
        while (right < N){
            if(tmp == M){
                result++;
                tmp -= num[left++];
            }else if(tmp < M){
                tmp += num[++right];
            }else{
                tmp -= num[left++];
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
