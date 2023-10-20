package com.boj_150.b_Sort.Level3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
public class Q04_11399 {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int N = sc.nextInt();
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            nums.add(sc.nextInt());
        }

        Collections.sort(nums);

        int result = 0;
        int tmp = 0;

        for (int i = 0; i < N; i++) {
            int target = nums.get(i);
            tmp += target;
            result += tmp;
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
