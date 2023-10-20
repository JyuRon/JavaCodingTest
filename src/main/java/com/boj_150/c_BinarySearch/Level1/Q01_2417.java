package com.boj_150.c_BinarySearch.Level1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Q01_2417 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double n = Long.parseLong(br.readLine());

        double answer = (Math.sqrt(n));
		if (answer * answer != n) {
			answer += 1;
		}
		System.out.println(answer);
    }
}
