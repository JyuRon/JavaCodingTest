package com.ndb_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/22860
 */
public class Q05_22860 {
    static FastReader sc = new FastReader();
    static int N, M;
    static Map<String, Folder> folders = new HashMap<>();
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < N+M; i++) {
            String parent = sc.next();
            String child = sc.next();
            int type = sc.nextInt();

            Folder parentFolder = getFolder(parent);

            if(type == 0){
                parentFolder.addFile(child);
            }else{
                Folder childFolder = getFolder(child);
                parentFolder.addChild(childFolder);
            }
        }
    }

    static void func(){
        dfs(getFolder("main"));

        int queryCount = sc.nextInt();
        while(queryCount-- > 0) {
            String query = sc.next();
            int index = query.lastIndexOf('/');

            if(index != -1){
                query = query.substring(index + 1);
            }

            Folder current = getFolder(query);
            int answer1 = current.files.size();
            int answer2 = current.count;
            System.out.println(answer1 + " " + answer2);
        }
    }

    static void dfs(Folder current) {
        for(Folder next : current.childes) {
            dfs(next);
            current.mergeFolder(next);
        }
    }

    static Folder getFolder(String name) {
        if(folders.containsKey(name)){
            return folders.get(name);
        }
        Folder newFolder = new Folder(name);
        folders.put(name, newFolder);
        return newFolder;
    }

    public static void main(String[] args) {
        input();
        func();
    }

    static class Folder{
        String name;
        Set<String> files = new HashSet<>();
        List<Folder> childes = new ArrayList<>();
        int count;

        public Folder(String name){
            this.name = name;
        }

        public void addChild(Folder childFolder){
            this.childes.add(childFolder);
        }

        public void addFile(String name){
            this.files.add(name);
            count++;
        }

        public void mergeFolder(Folder other) {
            files.addAll(other.files);
            count += other.count;
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
