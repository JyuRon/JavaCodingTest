package com.boj_150.d_twoPointer.Level2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Q01_11728 {
    static FastReader sc = new FastReader();
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] A,B, result;
        A = new int[N];
        B = new int[M];
        result = new int[N+M];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            B[i] = sc.nextInt();
        }


        int a = 0, b = 0, r = 0;
        while (a != N && b != M){
            int left = A[a];
            int right = B[b];

            if(left < right){
                result[r] = left;
                a++;
            }else{
                result[r] = right;
                b++;
            }
            r++;
        }

        if(a != N){
            for (int i = a; i < N; i++) {
                result[r++] = A[i];
            }
        }else{
            for (int i = b; i < M; i++) {
                result[r++] = B[i];
            }
        }

        for (int i = 0; i < N + M; i++) {
            sb.append(result[i]).append(" ");
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
