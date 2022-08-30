package task1;

public class RandomArray {

    public static int a = 31;
    public static int c = 1211;
    public static int m = 1202;
    public static int seed = 1;
    public static int[][] rndTwoDimArray (int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = getRandom();
            }
        }
        return array;
    }

    public static int getRandom()
    {
        seed = (a * seed + c) % m;
        return seed;
    }
}
