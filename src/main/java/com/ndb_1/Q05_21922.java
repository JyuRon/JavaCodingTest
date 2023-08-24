package com.ndb_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/21922
 */
public class Q05_21922 {
    static FastReader sc = new FastReader();
    static int N, M;
    static int[][] graph;
    static boolean[][][] visited;
    static List<Info> start;

    static int[][] dir = {{-1,0},{1,0},{0,-1}, {0,1}};

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        start = new ArrayList<>();
        graph = new int[N][M];
        visited = new boolean[N][M][4];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int object = sc.nextInt();
                graph[i][j] = object;

                if(object == 9){
                    start.add(new Info(i,j));
                }
            }
        }
    }

    static int bfs(){
        Queue<Info> Q = new LinkedList<>();

        for(Info node : start){
            for (int i = 0; i < 4; i++) {
                visited[node.x][node.y][i] = true;
                Q.add(new Info(node.x, node.y, dir[i]));
            }
        }

        int count = start.size();

        while (!Q.isEmpty()){
            Info current = Q.poll();

            int object = graph[current.x][current.y];
            int[] nextDir = nextDir(object, current.dir);
            int nextDirIndex = dirIndex(nextDir);
            int nextX = current.x + nextDir[0];
            int nextY = current.y + nextDir[1];


            // 범위를 벗어나는 경우
            if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M){
                continue;
            }

            // 다음 방향으로 이미 방문한 이력이 존재하는 경우
            if(visited[nextX][nextY][nextDirIndex]){
                continue;
            }

            Q.add(new Info(nextX, nextY, nextDir));

            boolean countCheck = true;
            for (int i = 0; i < 4; i++) {
                if(visited[nextX][nextY][i]){
                    countCheck = false;
                    break;
                }
            }

            if(countCheck)
                count++;
            visited[nextX][nextY][nextDirIndex] = true;
        }

        return count;
    }

    static int[] nextDir(int object, int[] dir){
        int[] result = new int[2];

        if(object == 1){
            result[0] = dir[0];
            result[1] = dir[1] * -1;
        }else if(object == 2){
            result[0] = dir[0] * -1;
            result[1] = dir[1];
        }else if(object == 3){
            result[0] = dir[1] * -1;
            result[1] = dir[0] * -1;
        }else if(object == 4){
            result[0] = dir[1];
            result[1] = dir[0];
        }else{
            result = dir;
        }
        return result;
    }

    static int dirIndex(int[] dir){

        int index = 0;
        // 상, 하, 좌, 우 순
        if(dir[0] == -1 && dir[1] == 0){
            index = 0;
        }else if(dir[0] == 1 && dir[1] == 0){
            index = 1;
        }else if(dir[0] == 0 && dir[1] == -1){
            index = 2;
        }else{
            index = 3;
        }

        return index;
    }

    public static void main(String[] args) {
        input();
        System.out.println(bfs());
    }


    static class Info{
        int x;
        int y;
        int[] dir;
        public Info(int x, int y){
            this.x = x;
            this.y = y;
        }
        public Info(int x, int y, int[] dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
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
