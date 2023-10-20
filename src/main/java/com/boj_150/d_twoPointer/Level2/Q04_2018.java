package com.boj_150.d_twoPointer.Level2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q04_2018 {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int N = sc.nextInt();

        int left = 1;
        int right = 1;
        int tmp = 0;
        int count = 0;

        while (left <= N){
            if(tmp == N){
                count++;
            }


            if(tmp < N){
                tmp += right++;
            }else{
                tmp -= left++;
            }
        }

        System.out.println(count);
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
