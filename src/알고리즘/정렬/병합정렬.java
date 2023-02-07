package 알고리즘.정렬;

import java.util.Arrays;

public class 병합정렬 {

    static int[] arr = {7, 6, 2, 4, 3, 9, 1};

    public static void main(String[] args) {
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    public static void sort(int[] arr,int left,int right){
        if(left<right){
            int mid = (left+right)/2;
            sort(arr,left,mid);
            sort(arr,mid+1,right);
            merge(arr,left,mid,right);
        }
    }
    public static void merge(int[] arr,int left,int mid,int right){
        int[] arrL = Arrays.copyOfRange(arr,left,mid+1);
        int[] arrR = Arrays.copyOfRange(arr,mid+1,right+1);

        int lp = 0;
        int rp = 0;
        int k = left;
        int lend = arrL.length;
        int rend = arrR.length;
        if(lp<lend && rp<rend){
            if(arrL[lp]<=arrR[rp]){
                arr[k++] = arrL[lp++];
            }
            else{
                arr[k++] = arrR[rp++];
            }
        }
        while(lp<lend){
            arr[k++] = arrL[lp++];
        }
        while(rp<rend){
            arr[k++] = arrR[rp++];
        }
    }
}
