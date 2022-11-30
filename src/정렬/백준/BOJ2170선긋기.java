package 정렬.백준;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.Comparator;

public class BOJ2170선긋기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        int[][] pos = new int[n][2];
        int result = 0;

        for(int i =0;i<n;i++){
            String line = br.readLine();
            int p1 = Integer.valueOf(line.split(" ")[0]);
            int p2 = Integer.valueOf(line.split(" ")[1]);
            pos[i][0] = p1;
            pos[i][1] = p2;
        }

        Arrays.sort(pos, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                else {
                    return o1[0] - o2[0];
                }
            }
        });

        int preS = pos[0][0];
        int preE = pos[0][1];
        int totalMinus = 0;
        for(int i =1;i<pos.length;i++){
            int newS = pos[i][0];
            int newE = pos[i][1];

            if(preE<newS){
                totalMinus+=newS-preE;
            }
            preE = Math.max(preE,newE);
        }

        System.out.println(preE-preS-totalMinus);
    }
}
