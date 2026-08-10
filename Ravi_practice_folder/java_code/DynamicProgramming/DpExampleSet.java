import java.util.Random;

public class DpExampleSet {
    public int[][] getArrayOfArray() {
        Random random = new Random();
        int[][] arrays = new int[20][];

        for (int i = 0; i < arrays.length; i++) {
            int length = random.nextInt(6) + 1; // random length from 1 to 6
            arrays[i] = new int[length];

            for (int j = 0; j < arrays[i].length; j++) {
                arrays[i][j] = random.nextInt(100); // random value from 0 to 99
            }
        }

        return arrays;
    }
}
