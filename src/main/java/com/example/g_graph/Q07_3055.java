package com.example.g_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/3055
 */
public class Q07_3055 {
    static FastReader sc = new FastReader();
    static int R,C;
    static String[] graph;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static int result = Integer.MAX_VALUE;


    static int[][] distance;
    static boolean[][] visited;


    static int[][] waterDistance;


    static boolean[][] waterVisited;

    static void input(){
        R = sc.nextInt();
        C = sc.nextInt();

        distance = new int[R][C];
        visited = new boolean[R][C];



        graph = new String[R];



        for (int i = 0; i < R; i++) {
            graph[i] = sc.next();
        }
    }

    static void func(){
        int animalX = -1, animalY = -1;
        int houseX = -1, houseY = -1;

        // 고슴도치, 집 , 물 위치 파악
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(graph[i].charAt(j) == 'S'){
                    animalX = i; animalY = j;
                }else if(graph[i].charAt(j) == 'D'){
                    houseX = i; houseY = j;
                }
            }
        }
        addWater();
        waterDistance[houseX][houseY] = -1;

        moveAnimal(animalX, animalY);
        result = distance[houseX][houseY];
    }


    static void addWater(){
        waterVisited = new boolean[R][C];
        waterDistance = new int[R][C];
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                waterDistance[i][j] = -1;
                if(graph[i].charAt(j) == '*'){
                    Q.add(i);
                    Q.add(j);
                    waterDistance[i][j] = 0;
                    waterVisited[i][j] = true;
                }
            }
        }


        while (!Q.isEmpty()){
            int x = Q.poll();
            int y = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = x + dir[i][0];
                int nextY = y + dir[i][1];

                // 영역을 벗어나는 경우
                if(nextX < 0 || nextY < 0 || nextX >= R || nextY >= C){
                    continue;
                }

                // 이미 방문 기록이 있는 경우
                if(waterVisited[nextX][nextY]){
                    continue;
                }

                // 이동 불가 지역인 경우
                if(graph[nextX].charAt(nextY) == 'X' || graph[nextX].charAt(nextY) == 'D'){
                    continue;
                }

                Q.add(nextX);
                Q.add(nextY);
                waterDistance[nextX][nextY] = waterDistance[x][y] + 1;
                waterVisited[nextX][nextY] = true;
            }

        }
    }

    static void moveAnimal(int animalX, int animalY){
        Queue<Integer> Q = new LinkedList<>();
        visited[animalX][animalY] = true;
        distance[animalX][animalY] = 0;
        Q.add(animalX);
        Q.add(animalY);

        while (!Q.isEmpty()){
            int x = Q.poll();
            int y = Q.poll();

            for (int i = 0; i < 4; i++) {

                int nextX = x + dir[i][0];
                int nextY = y + dir[i][1];

                // 범위를 벗어나는 경우
                if(nextX < 0 || nextY < 0 || nextX >= R || nextY >= C ){
                    continue;
                }

                // 이미 방문한 이력이 있는 경우
                if(visited[nextX][nextY]){
                    continue;
                }

                // 이동불가 지역인 경우
                if(graph[nextX].charAt(nextY) == '*' || graph[nextX].charAt(nextY) == 'X'){
                    continue;
                }

                // 웅덩이가 존재하거나 이동 직후 생기는 경우
                if(distance[x][y] + 1 >= waterDistance[nextX][nextY] && waterDistance[nextX][nextY] != -1){
                    continue;
                }

                distance[nextX][nextY] = distance[x][y] + 1;
                visited[nextX][nextY] = true;
                Q.add(nextX);
                Q.add(nextY);

            }
        }
    }



    public static void main(String[] args) {
        input();
        func();

        if(result == 0){
            System.out.println("KAKTUS");
        }else{
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
