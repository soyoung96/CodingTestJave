package 알고리즘.정렬;

import java.util.Arrays;

public class 삽입정렬 {
    static int[] arr = {7, 6, 2, 4, 3, 9, 1};

    public static void main(String[] args) {
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void sort(int[] arr){
        for(int i =1;i<arr.length;i++){
            int elt = arr[i];
            int j;
            for(j = i-1;0<=j && arr[j]>elt;j--){
                arr[j+1] = arr[j];
            }
            arr[j+1] = elt;
        }
    }
}
