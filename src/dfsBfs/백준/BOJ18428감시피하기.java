package dfsBfs.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ18428감시피하기 {
    static int n;
    static char[][] map;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static class Node{
        int x;
        int y;
        Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<Node> teachers = new ArrayList<>();
    static ArrayList<Node> blanks = new ArrayList<>();

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.valueOf(br.readLine());
        map = new char[n][n];

        for(int x =0;x<n;x++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int y =0;y<n;y++){
                map[x][y] = st.nextToken().charAt(0);
                if(map[x][y] == 'T'){
                    teachers.add(new Node(x,y));
                }
                if(map[x][y] == 'X'){
                    blanks.add(new Node(x,y));
                }
            }

        }
        visited = new boolean[blanks.size()];
        comb(0,0);
        System.out.println("NO");

    }


    static void comb(int depth,int start){
        if(depth == 3){
            char[][] tmpMap = new char[n][n]; //맵 깊은 복사
            for(int x=0;x<n;x++){
                for(int y = 0;y<n;y++){
                    tmpMap[x][y] = map[x][y];
                }
            }

            for(int i=0;i<blanks.size();i++){
                if(visited[i]){
                    Node n = blanks.get(i);
                    tmpMap[n.x][n.y] = 'O'; //장애물 설치
                }
            }
            if(bfs(tmpMap)){
                System.out.println("YES");
                System.exit(0);
            }

        }
        else{
            for(int i = start;i<blanks.size();i++){
                if(!visited[i]){
                    visited[i] = true;
                    comb(depth+1,start+1);
                    visited[i] = false;
                }
            }
        }
    }

    static boolean checkXY(int xy){
        if(0<=xy && xy<n){
            return true;
        }
        else{
            return false;
        }
    }

    static boolean bfs(char[][] tmpMap){ // 장애물에 다 막아지면 true 안님 false
        for(int x=0;x<n;x++){
            for(int y =0;y<n;y++){
                if(tmpMap[x][y]=='T'){
                    for(int go=0;go<4;go++){
                        int nextX = x+dx[go];
                        int nextY = y+dy[go];
                        while(checkXY(nextX) && checkXY(nextY)){//갈 수 있으면
                            if(tmpMap[nextX][nextY]=='O'){
                                break;
                            }
                            else{
                                if(tmpMap[nextX][nextY]=='S'){
                                    return false;
                                }
                            }
                            nextX = nextX+dx[go];
                            nextY = nextY+dy[go];
                        }
                    }

                }
            }
        }
        return true;
    }

}
