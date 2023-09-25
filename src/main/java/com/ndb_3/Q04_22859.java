package com.ndb_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/22859
 */
public class Q04_22859 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        String html = sc.nextLine();
        int L = 0, N = html.length();

        while(L < N) {
            int index = html.indexOf("title=\"", L);
            if(index == -1) break;
            int end_title = html.indexOf("\">", index);
            int end_tag   = html.indexOf("</div>", index);
            String title  = html.substring(index + 7, end_title);
            System.out.println("title : " + title);

            int cursor = L;
            while(true) {
                int start_p_tag = html.indexOf("<p>", cursor);
                if(start_p_tag == -1) break;
                if(start_p_tag >  end_tag) break;
                int end_p_tag = html.indexOf("</p>", start_p_tag);
                String paragraph = html.substring(start_p_tag + 3, end_p_tag);
                String erased = erase_simple_tag(paragraph);
                System.out.println(erased);
                cursor = end_p_tag;
            }
            L = end_tag;
        }
    }

    static String erase_simple_tag(String line) {
        String ret = "";
        boolean space = true;
        boolean bracket_open = false;
        for(int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == '>') {
                bracket_open = false;
                continue;
            }

            if(line.charAt(i) == '<') {
                bracket_open = true;
                continue;
            }

            if(bracket_open) continue;
            if(line.charAt(i) == ' ') {
                if(space) continue;
                space = true;
                ret += line.charAt(i);
            }
            else {
                space = false;
                ret += line.charAt(i);
            }
        }
        return ret.trim();
    }



    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
