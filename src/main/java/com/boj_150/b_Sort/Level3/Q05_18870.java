package com.boj_150.b_Sort.Level3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q05_18870 {
    static FastReader sc = new FastReader();
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {
        int N = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < N; i++) {
            int target = sc.nextInt();
            list.add(target);
            set.add(target);
        }

        List<Integer> tmp = new ArrayList<>(set);

        for (int i = 0; i < tmp.size(); i++) {
            int target = tmp.get(i);

            if(!map.containsKey(target)){
                map.put(target, i);
            }
        }


        for (int i = 0; i < N; i++) {
            int value = list.get(i);
            sb.append(map.get(value)).append(" ");
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
