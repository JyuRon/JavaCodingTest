package com.boj_150.b_Sort.Level3;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
public class Q03_2776 {
    static FastReader sc = new FastReader();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static List<Integer> a,b;
    static void input(){
        a = new ArrayList<>();
        b = new ArrayList<>();

        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            a.add(sc.nextInt());
        }

        M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            b.add(sc.nextInt());
        }

        Collections.sort(a);
    }

    static void func(){
        for (int i = 0; i < M; i++) {
            try {
                bw.write(binarySearch(b.get(i)));
                bw.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    static String binarySearch(int value){
        int bottom = 0;
        int top = N-1;

        while (bottom <= top){
            int mid = (bottom + top) / 2;
            int target = a.get(mid);

            if(target == value){
                return "1";
            }

            if(target < value){
                bottom = mid + 1;
            }else{
                top = mid - 1;
            }

        }
        return "0";
    }

    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();

        while (t-- > 0){
            input();
            func();
        }
        bw.flush();
        bw.close();
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
