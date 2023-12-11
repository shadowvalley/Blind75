/**
 * 
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 * Number of Connected Components in an Undirected Graph
 */

class Solution {
    public int countComponents(int n, int[][] edges) {
        // Step - 0 -> Convert adjacency matrix to adjacency list 
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int componentCount = 0;
        
        // Step - 1 -> Create a boolean visited array and set everything to False.
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++) {
            visited[i] = false;
        }

        // Step - 2 -> Traverse the graph
        for(int i=0;i<n; i++) {
            if(visited[i] == false) {
                componentCount += 1;
                bfs(i, adj, visited);
            }
        }
        return componentCount;
    }

    private void bfs(int startNode, List<List<Integer>> adj, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        vis[startNode] = true;  
        q.offer(startNode);

        while(!q.isEmpty()) {
            int node = q.poll();
            
            for(Integer it: adj.get(node)) {
                if(!vis[it]) {
                    q.offer(it);
                    vis[it] = true;
                }
            }
        }
    }
}