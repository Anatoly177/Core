package task1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        RandomArray random = new RandomArray();
        MaximumValue maximum = new MaximumValue();
        MinimumValue minimum = new MinimumValue();
        AverageValue average = new AverageValue();

        int[][] testArray = random.rndTwoDimArray(new int[4][4]);

        System.out.println("Array: " + Arrays.deepToString(testArray) + "\n");
        System.out.println("Maximum: " + maximum.maxValue(testArray) + "\n");
        System.out.println("Minimum: " + minimum.minValue(testArray) + "\n");
        System.out.println("Average: " + average.avrValue(testArray));

    }
}
