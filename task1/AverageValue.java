package task1;

public class AverageValue {

    public static int avrValue (int[][] array) {
        int count = array.length * array[0].length;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                sum += Math.abs(array[i][j]);
                }
            }
        return sum/count;
        }
    }
