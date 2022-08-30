package task2;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] arr = {5, 6, 3, 2, 5, 1, 4, 9};

        for (int j = 0; j < arr.length - 1; j++){
            for (int i = 0; i < arr.length - j - 1; i++){
                if (arr[i] > arr[i + 1]){
                    int tmp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
