/**
 * https://leetcode.com/problems/graph-valid-tree/description/
 * Graph Valid Tree
 */

class Pair {
    int first;
    int second;
    
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    } 
}

class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        for(int i=0;i<visited.length;i++) visited[i] = false;
        boolean hasCycle = false;
        int graphComponents = 0;

        for(int j=0;j<n;j++) {
             if(visited[j] == false) {
                graphComponents++;
                hasCycle = bfs(j, adj, visited);
                if(hasCycle) {
                    return !hasCycle;
                }
             }
        }
        
        if(graphComponents < 2 && !hasCycle) return true;
        return false;
    }

    private boolean bfs(int src, List<List<Integer>> adj, boolean[] vis) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src, -1));
        vis[src] = true;
        
        while(!q.isEmpty()) {
            Pair pr = q.poll();
            int nodeValue = pr.first;
            int parentValue = pr.second;
            
            // traverse all it's children
            for(int adjacentNode: adj.get(nodeValue)) {
                if(vis[adjacentNode]!= true) {
                    vis[adjacentNode] = true;
                    q.offer(new Pair(adjacentNode, nodeValue));
                } else {
                    // if the node is already visited, but the current node is not 
                    // it's parent, which means there is a cycle
                    if(parentValue != adjacentNode) return true;
                }
            }
        }
        
        return false;
    }
}