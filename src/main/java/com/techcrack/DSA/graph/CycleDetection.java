package com.techcrack.dsa.graph;

import java.util.*;

class CycleDetection {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        boolean[] isVisited = new boolean[adj.size()];
        
        for (int i = 0; i < adj.size(); i++) {
            if (isVisited[i]) continue;
            
            if (isCycleDetected(adj, isVisited, i))
                return true;
        }
        
        return false;
    }
    
    private boolean isCycleDetected(ArrayList<ArrayList<Integer>> adj, boolean[] isVisited, int curNode) {
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.add(new int[]{curNode, -1});
        isVisited[curNode] = true;
        
        while (! queue.isEmpty()) {
            int node = queue.peek()[0];
            int parent = queue.poll()[1];
            
            for (Integer ad : adj.get(node)) {
                if (ad == parent) continue;
                
                if (isVisited[ad]) return true;
            
                queue.add(new int[]{ad, node});
                isVisited[ad] = true;
            }
        }
        return false;
    }
}