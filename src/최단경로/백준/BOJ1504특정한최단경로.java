package 최단경로.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1504특정한최단경로 {
    static int n,e,v1,v2;
    final static int INF = Integer.MAX_VALUE/10;
    static ArrayList<Node>[] graph;
    static int[] dp;
    static BufferedReader br;
    static StringTokenizer st;
    static PriorityQueue<Node> priorityQueue;
    public static class Node implements Comparable<Node>{
        int dist;
        int node;
        Node(int dist,int node){
            this.dist = dist;
            this.node =node;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        e = Integer.valueOf(st.nextToken());

        graph = new ArrayList[n+1];
        dp = new int[n+1];

        for(int i =0;i<n+1;i++){
            dp[i] = INF;
            graph[i] = new ArrayList<>();
        }

        for(int i =0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int c = Integer.valueOf(st.nextToken());
            graph[a].add(new Node(c,b));
            graph[b].add(new Node(c,a));
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.valueOf(st.nextToken());
        v2 = Integer.valueOf(st.nextToken());

        priorityQueue = new PriorityQueue<>();

        int firstCase = dickstra(arrayCopy(dp), priorityQueue,graph,1,v1)
                + dickstra(arrayCopy(dp), priorityQueue,graph,v1,v2)
                +dickstra(arrayCopy(dp), priorityQueue,graph,v2,n);

        int secondCase = dickstra(arrayCopy(dp), priorityQueue,graph,1,v2)
                + dickstra(arrayCopy(dp), priorityQueue,graph,v2,v1)
                +dickstra(arrayCopy(dp), priorityQueue,graph,v1,n);

        if(firstCase>=INF && secondCase>=INF){
            System.out.println(-1);
        }
        else{
            System.out.println(Integer.min(firstCase,secondCase));
        }



    }
    public static int[] arrayCopy(int[] dp){
        int[] dp1 = new int[dp.length];
        for(int i =0;i<dp.length;i++){
            dp1[i] = dp[i];
        }
        return dp1;
    }
    public static int dickstra(int[] dp, PriorityQueue<Node> priorityQueue,
                               ArrayList<Node>[] graph,int startN,int endN){
        priorityQueue.add(new Node(0,startN));

        while(!priorityQueue.isEmpty()){
            Node node = priorityQueue.poll();
            int dist = node.dist;
            int nodeE = node.node;
            if(dp[nodeE]>dist){
                dp[nodeE] = dist;
                for(Node nNode:graph[nodeE]){
                    int newDist = nNode.dist+dist;
                    int nNodeE = nNode.node;
                    if(dp[nNodeE]>newDist){
                        priorityQueue.add(new Node(newDist,nNodeE));
                    }
                }
            }
        }
        return dp[endN];
    }

}
