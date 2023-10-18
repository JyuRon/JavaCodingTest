package com.boj_150.b_Sort.Level1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q01_2752 {
    static FastReader sc = new FastReader();
    static List<Integer> nums = new ArrayList<>();
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            nums.add(sc.nextInt());
        }
        Collections.sort(nums);

        for (int i = 0; i < 3; i++) {
            sb.append(nums.get(i)).append(" ");
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
