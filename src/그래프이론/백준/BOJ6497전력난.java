package 그래프이론.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ6497전력난 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static Edge[] edges;
    static int[] rootL;
    static int totalCost;
    static int minCost;
    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int cost;

        Edge(int start,int end,int cost){
            this.start =start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
    public static int findRoot(int node,int[] rootL){
        if(node != rootL[node]){
            rootL[node] = findRoot(rootL[node],rootL);
        }
        return rootL[node];
    }
    public static boolean sumNodes(int node1,int node2,int[] rootL){
        int root1 = findRoot(node1,rootL);
        int root2 = findRoot(node2,rootL);
        if(root1 != root2){ //합침
            if(root1<root2){
                rootL[root2] = root1;
            }
            else{
                rootL[root1] = root2;
            }
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {

        while(true){
            totalCost =0;
            minCost =0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if(m == 0 && n == 0){
                break;
            }
            edges = new Edge[n];
            rootL = new int[m];

            for(int i = 0;i<m;i++){
                rootL[i] = i;
            }

            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                int x= Integer.parseInt(st.nextToken());
                int y= Integer.parseInt(st.nextToken());
                int z= Integer.parseInt(st.nextToken());
                Edge edge = new Edge(x,y,z);
                edges[i] = edge;
                totalCost += z;
            }
            Arrays.sort(edges);

            for(Edge edge:edges){
                int node1 = edge.start;
                int node2 = edge.end;
                int cost = edge.cost;
                if(sumNodes(node1,node2,rootL)){
                    minCost += cost;
                }
            }

            System.out.println(totalCost - minCost);
        }

    }
}
