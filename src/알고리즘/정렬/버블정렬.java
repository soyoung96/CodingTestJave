package 알고리즘.정렬;

import java.util.Arrays;

public class 버블정렬 {
    static int[] arr = {7, 6, 2, 4, 3, 9, 1};

    public static void main(String[] args) {
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void sort(int[] arr){
        for(int i =0;i<arr.length-1;i++){

            for(int j = 0;j<arr.length-i-1;j++){
                if(arr[j+1]<arr[j]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
}
