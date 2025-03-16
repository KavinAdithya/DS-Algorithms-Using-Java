package com.techcrack.dsa.revisit;

import java.util.*;

public class BreadthFirstSearch {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] isVisited = new boolean[V];

        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(0);

        ArrayList<Integer> res = new ArrayList<>();

        res.add(0);

        outer : while (! queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                if (queue.isEmpty()) break outer;

                int cur = queue.poll();

                for (Integer ad : adj.get(cur)) {
                    if (isVisited[ad]) continue;

                    isVisited[ad] = true;
                    res.add(ad);
                    queue.add(ad);

                }
            }
        }

        return res;
    }
}
