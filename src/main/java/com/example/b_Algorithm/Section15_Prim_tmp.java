package com.example.b_Algorithm;

import java.util.*;

public class Section15_Prim_tmp {

    public List<EdgeMST> primFunc(String startNode, List<EdgeMST> edges){
        List<EdgeMST> mst = new ArrayList<>();

        return mst;
    }

    public static void main(String[] args) {
        List<EdgeMST> myedges = new ArrayList<>();
        myedges.add(new EdgeMST(7, "A", "B"));
        myedges.add(new EdgeMST(5, "A", "D"));
        myedges.add(new EdgeMST(8, "B", "C"));
        myedges.add(new EdgeMST(9, "B", "D"));
        myedges.add(new EdgeMST(7, "D", "E"));
        myedges.add(new EdgeMST(5, "C", "E"));
        myedges.add(new EdgeMST(7, "B", "E"));
        myedges.add(new EdgeMST(6, "D", "F"));
        myedges.add(new EdgeMST(8, "E", "F"));
        myedges.add(new EdgeMST(9, "E", "G"));
        myedges.add(new EdgeMST(11, "F", "G"));

        Section15_Prim_tmp prim = new Section15_Prim_tmp();
        for (EdgeMST edge : prim.primFunc("A", myedges)){
            System.out.println(edge);
        }

    }
}
