package com.boj_150.f_Tree.Level2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Q02_20364 {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int N = sc.nextInt();
        int Q = sc.nextInt();

        int[] nums = new int[N+1];

        for (int i = 0; i < Q; i++) {
            int target = sc.nextInt();

            int next = target;
            int result = 0;
            boolean flag = true;

            while (next != 0){
                if(nums[next] != 0){
                    result = next;
                    flag = false;
                }
                next /= 2;
            }

            if(flag) nums[target] = 1;
            System.out.println(result);
        }
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
