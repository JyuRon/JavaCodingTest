package com.boj_150.c_BinarySearch.Level2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Q02_1072 {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int X = sc.nextInt();
        int Y = sc.nextInt();
        long Z = ((long)Y * 100) / X;

        int result = -1;
        int bottom = 1;
        int top = 1000000000;

        while (bottom <= top){
            int mid = (bottom + top) / 2;
            long tmp = (((long)Y + mid) * 100) / (X + mid);

            if(tmp == Z){
                bottom = mid + 1;
            }else{
                top = mid - 1;
                result = mid;
            }
        }

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
