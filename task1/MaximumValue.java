package task1;

public class MaximumValue {

    public static int maxValue (int[][] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
    return max;
    }
}
