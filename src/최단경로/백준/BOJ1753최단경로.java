package 최단경로.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1753최단경로 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Node>[] graph;
    static int[] distance;
    static int INF = 1000000000;
    static class Node implements Comparable<Node>{
        int cost;
        int end;

        Node(int cost,int end){
            this.cost = cost;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            return cost-o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        graph = new ArrayList[v+1];
        distance = new int[v+1];

        Arrays.fill(distance,INF);

        for(int i = 1; i < v+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i= 0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(cost,end));
        }
        dijkstra(k);

        for (int i =1;i<v+1;i++){
            if(distance[i] == INF){
                System.out.println("INF");
            }
            else{
                System.out.println(distance[i]);
            }
        }

    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,start));

        while(!pq.isEmpty()){
            Node nowNode = pq.poll();
            int nowCost = nowNode.cost;
            int nowEnd = nowNode.end;
            if(nowCost<distance[nowEnd]){
                distance[nowEnd] = nowCost; //갱신
                for(Node nextNode: graph[nowEnd]){
                    int nextCost = nextNode.cost;
                    int nextEnd = nextNode.end;
                    if(distance[nextEnd]>nowCost+nextCost){
                        pq.add(new Node(nowCost+nextCost,nextEnd));
                    }
                }
            }

        }
    }
}
