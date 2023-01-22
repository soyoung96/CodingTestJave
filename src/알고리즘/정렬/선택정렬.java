package 알고리즘.정렬;

import java.util.Arrays;

public class 선택정렬 {
    static int[] arr = {7, 6, 2, 4, 3, 9, 1};

    public static void main(String[] args) {
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void sort(int[] arr){
        for(int i =0;i<arr.length-1;i++){
            int minE = arr[i];
            int minInd = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j]<minE){
                    minE = arr[j];
                    minInd = j;
                }
                int tmp = arr[i];
                arr[i] = arr[minInd];
                arr[minInd] = tmp;
            }
        }
    }
}
