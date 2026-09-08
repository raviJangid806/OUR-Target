package Ravi_practice_folder.ApnaCollegeDsaSheet.BinaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.swing.Painter;

public class AllQuestion {

    public ArrayList<Integer> bottomView(Node root) {

        SortedMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(q.size()>0){
            Pair pair = new Pair(q.remove());
            map.put(pair.hd, pair.node.data);
            if(pair.node.left != null){
                q.add(new Pair(pair.node.left, pair.hd-1));
            }
            if(pair.node.right != null){
                q.add(new Pair(pair.node.right, pair.hd+1));
            }
        }
        ArrayList<Integer> list = new ArrayList<>(map.values());

        return list;
    }

   
}

class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;

    }
}

class Pair {

    Node node;
    int hd;
    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
    Pair(Pair p){
        this.node = p.node;
        this.hd = p.hd;
    }
}