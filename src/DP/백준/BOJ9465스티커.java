package DP.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9465스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());

        for(int i =0;i<t;i++){
            int n = Integer.parseInt(bf.readLine());
            int[][] dpL = new int[2][n];
            for(int j =0;j<2;j++){
                StringTokenizer inputL = new StringTokenizer(bf.readLine());
                for (int c=0;c<n;c++){
                    dpL[j][c] = Integer.parseInt(inputL.nextToken());
                }
            }

            int maxNm2 = -1;
            for (int c=0;c<n;c++){
                if(c==0){
                    continue;
                }
                else{
                    dpL[0][c] = Math.max(dpL[1][c-1]+dpL[0][c],maxNm2+dpL[0][c]);
                    dpL[1][c]= Math.max(dpL[0][c-1]+dpL[1][c],maxNm2+dpL[1][c]);
                    maxNm2 = Math.max(Math.max(dpL[0][c-1],dpL[1][c-1]),maxNm2);
                }
            }
            maxNm2 = Math.max(Math.max(dpL[0][n-1],dpL[1][n-1]),maxNm2);

            System.out.println(maxNm2);
        }

    }
}
