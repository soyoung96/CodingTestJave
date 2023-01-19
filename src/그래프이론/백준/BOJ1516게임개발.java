package 그래프이론.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1516게임개발 {
    static int n;
    static int[] times,inDegree,ansTimes;
    static ArrayList<Integer>[] graph;
    static BufferedReader br;
    static StringTokenizer st;
    static Queue<Node> queue = new LinkedList<>();

    static class Node{
        int completeBNum;
        int completeT;
        Node(int completeBNum,int completeT){
            this.completeBNum = completeBNum;
            this.completeT = completeT;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        times = new int[n+1];
        graph = new ArrayList[n+1];
        inDegree = new int[n+1];
        ansTimes = new int[n+1];

        for(int i =0;i<n+1;i++){
            times[i] = 0;
            ansTimes[i] =0;
            inDegree[i] =0;
            graph[i] = new ArrayList<>();
        }

        for(int buildingNum =1;buildingNum<n+1;buildingNum++){
            st = new StringTokenizer(br.readLine());
            int trial = 0;
            while(true){
                int elt = Integer.parseInt(st.nextToken());
                if(elt == -1){
                    break;
                }
                if(trial == 0){
                    times[buildingNum] = elt;
                }
                else{
                    graph[elt].add(buildingNum);
                    inDegree[buildingNum]+=1;
                }
                trial+=1;
            }
        }

        for(int buildingNum =1;buildingNum<n+1;buildingNum++){
            if(inDegree[buildingNum] == 0){
                queue.offer(new Node(buildingNum,times[buildingNum]));
            }
        }

        while(!queue.isEmpty()){
            Node node = queue.poll();
            ansTimes[node.completeBNum] = node.completeT;
            for(int nextBNum: graph[node.completeBNum]){
                ansTimes[nextBNum] = Math.max(ansTimes[nextBNum],
                        node.completeT+times[nextBNum]);
                inDegree[nextBNum]-=1;
                if(inDegree[nextBNum]==0){
                    queue.offer(new Node(nextBNum,ansTimes[nextBNum]));
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        for(int buildingNum =1;buildingNum<n+1;buildingNum++){
            sb.append(ansTimes[buildingNum]+"\n");
        }
//        for(int buildingNum =1;buildingNum<n+1;buildingNum++){
//            System.out.println(ansTimes[buildingNum]);
//        }
        System.out.println(sb);


    }
}
