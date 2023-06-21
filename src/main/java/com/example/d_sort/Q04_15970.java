package com.example.d_sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/15970
 */
public class Q04_15970 {

    static Scanner sc = new Scanner(System.in);
    static int N;
    static Elem[] points;

    static class Elem implements Comparable<Elem>{
        int distance;
        int color;

        @Override
        public int compareTo(Elem elem){
            if(this.color == elem.color){
                return this.distance - elem.distance;
            }

            return this.color - elem.color;
        }


    }

    static void input(){
        N = sc.nextInt();
        points = new Elem[N];
        for (int i = 0; i < N; i++) {
            points[i] = new Elem();
            points[i].distance = sc.nextInt();
            points[i].color = sc.nextInt();
        }
    }
    public static void main(String[] args) {
        int result = 0;
        input();
        Arrays.sort(points);
        for (int i = 0; i < N; i++) {
            if(i == 0){
                if(points[i+1].color == points[i].color){
                    result += (points[i+1].distance - points[i].distance);
                }
            }else if(i == N-1){
                if(points[i-1].color == points[i].color){
                    result += (points[i].distance - points[i-1].distance);
                }
            }else{
                int rightDistance = Integer.MAX_VALUE, leftDistance = Integer.MAX_VALUE;
                if(points[i+1].color == points[i].color){
                    rightDistance = points[i+1].distance - points[i].distance;
                }

                if(points[i-1].color == points[i].color){
                    leftDistance = points[i].distance - points[i-1].distance;
                }

                result += Math.min(leftDistance, rightDistance);
            }
        }

        System.out.println(result);
    }
}
