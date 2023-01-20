package dfsBfs.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2668숫자고르기 {
    static int n;
    static int[] chart;
    static int sumAns =0;
    static ArrayList<Integer> sumVisited = new ArrayList<>();
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        chart = new int[n+1];
        chart[0] = -1;
        for(int i=1;i<n+1;i++){
            st = new StringTokenizer(br.readLine());
            chart[i] = Integer.valueOf(st.nextToken());
        }

        int ans =0;
        for(int startInd =1;startInd<n+1;startInd++){
            if(!sumVisited.contains(startInd)){
                boolean[] visited = new boolean[n+1];
                for(int i =0;i<n+1;i++){
                    visited[i] = false;
                }
                ans = dfs(startInd,startInd,chart,1,visited);
                if(ans!=-1){
                    sumAns+=ans;
                    for(int i =1;i<n+1;i++){
                        if(visited[i] == true){
                            sumVisited.add(i);
                        }
                    }
                }
            }

        }
        Collections.sort(sumVisited);
        StringBuilder sb = new StringBuilder();
        sb.append(sumAns+"\n");
        for(int elt:sumVisited){
            sb.append(elt+"\n");
        }
        System.out.println(sb);

    }
    public static int dfs(int startInd,int ind,int[] chart,int dfsIterNum,
                          boolean[] visited){
        visited[ind] = true;
        if(chart[ind] == startInd){
            return dfsIterNum;
        }
        else{
            if(visited[chart[ind]]!=true){
                return dfs(startInd,chart[ind],chart,dfsIterNum+1,visited);
            }else{
                return -1;
            }
        }


    }
}
