package com.boj_150.c_BinarySearch.Level2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Q04_2792 {
    static FastReader sc = new FastReader();

    static int M;
    static int N;
    static int[] v;

    static int solve(int k)
    {
        int ret = 0;
        for (int i = 0; i < M; i++)
        {
            ret += (v[i] + k - 1) / k;
        }
        return ret;
    }

    static int bs(int right)
    {
        int l = 1;
        int r = right;
        int m = (l + r) / 2;
        while (l < r)
        {
            m = (l + r) / 2;
            if (solve(m) <= N)
            {
                r = m;
            }
            else
            {
                l = m + 1;
            }
        }
        return r;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        v = new int[M];
        int right = 0;
        for (int i = 0; i < M; i++) {
            v[i] = Integer.parseInt(br.readLine());
            right = Math.max(right,  v[i]);
        }

        int answer = bs(right);

        System.out.println(answer);
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
