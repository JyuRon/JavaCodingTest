package com.boj_150.b_Sort.Level1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q02_5576 {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        List<Integer> w = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            w.add(sc.nextInt());
        }
        Collections.sort(w, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 - o2) * -1;
            }
        });


        List<Integer> k = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            k.add(sc.nextInt());
        }
        Collections.sort(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 - o2) * -1;
            }
        });


        int totalK = 0, totalW = 0;

        for (int i = 0; i < 3; i++) {
            totalW += w.get(i);
            totalK += k.get(i);
        }

        System.out.println(totalW + " " + totalK);
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
