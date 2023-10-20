package com.boj_150.c_BinarySearch.Level2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
public class Q01_1920 {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int N = sc.nextInt();
        List<Integer> nums = new ArrayList<>();
        List<Integer> p = new ArrayList<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int value = sc.nextInt();
            nums.add(value);
        }
        Collections.sort(nums);

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            p.add(sc.nextInt());
        }

        for (int i = 0; i < M; i++) {
            int target = p.get(i);

            int result = 0;
            int bottom = 0;
            int top = N - 1;

            while (bottom <= top){
                int mid = (bottom + top) / 2;
                int current = nums.get(mid);
                if(current == target){
                    result = 1;
                    break;
                }else if(current < target){
                    bottom = mid + 1;
                }else{
                    top = mid - 1;
                }

            }

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
