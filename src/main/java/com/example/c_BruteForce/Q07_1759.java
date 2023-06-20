package com.example.c_BruteForce;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1759
 */

public class Q07_1759 {


    static int L, C;
    // 자음
    static int consonant = 0;

    static String[] charSet;

    // 모음
    static int vowel = 0;

    static Scanner sc = new Scanner(System.in);

    static void input(){
        L = sc.nextInt();
        C = sc.nextInt();

        charSet = new String[C];
        for (int i = 0; i < C; i++) {
            charSet[i] = sc.next();
        }


        Arrays.sort(charSet);

    }

    static void func(int length, int depth, String result){


        if(length == L){
            if(vowel >= 1 && consonant>= 2)
                System.out.println(result);
            return;
        }

        if(depth == C){
            return;
        }


        if(charSet[depth].equals("a") || charSet[depth].equals("e") || charSet[depth].equals("i") || charSet[depth].equals("o") || charSet[depth].equals("u")){
            vowel++;
            func(length + 1, depth+1, result.concat(charSet[depth]));
            vowel--;
        }else{
            consonant++;
            func(length + 1, depth+1, result.concat(charSet[depth]));
            consonant--;
        }


        func(length, depth+1, result);


    }

    public static void main(String[] args) {
        input();
        func(0,0,"");
    }
}
