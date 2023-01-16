package DP.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2294동전2 {

    final static int INF = Integer.MAX_VALUE-1;
    static int n,k;
    static BufferedReader br;
    static StringTokenizer st;
    static ArrayList<Integer> moneyL = new ArrayList<>();
    static int[] dp;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.valueOf(st.nextToken());
        k = Integer.valueOf(st.nextToken());

        dp = new int[k+1];

        for(int i = 0;i<k+1;i++){
            dp[i] = INF;
        }

        for(int i =0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int money = Integer.valueOf(st.nextToken());
            if(money<=k){
                moneyL.add(money);
                dp[money] = 1;
            }
        }

        for(int i = 0;i<moneyL.size();i++){
            for(int j = moneyL.get(i);j<k+1;j++){
                dp[j] = Integer.min(dp[j],dp[j-moneyL.get(i)]+1);
            }
        }

        if(dp[k] == INF){
            dp[k] = -1;
        }

        System.out.println(dp[k]);

    }
}
