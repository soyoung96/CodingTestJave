package 정렬.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ18870좌표압축 {
    static int n;
    static ArrayList<Node> nodeL = new ArrayList<Node>();
    static int[] answer;
    static int preV = 1000000001;
    static int nowV;
    static int count;
    static class Node implements Comparable<Node>{
        int val;
        int ind;

        Node(int val,int ind){
            this.val = val;
            this.ind =ind;
        }

        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));

        n = Integer.valueOf(bf.readLine());
        answer = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++){//1000000
            Node node = new Node(Integer.parseInt(st.nextToken()),i);
            nodeL.add(node);
        }

        Collections.sort(nodeL); //1000000log1000000

        int nodeLInd = 0;
        for(Node node:nodeL){
            if(preV == node.val){
                count +=1;
            }
            answer[node.ind] = nodeLInd- count;
            preV = node.val;
            nodeLInd+=1;
        }

        StringBuilder sb = new StringBuilder("");
        for(int answerE:answer){
            sb.append(answerE+" ");

        }
        System.out.print(sb.toString());



    }
}
