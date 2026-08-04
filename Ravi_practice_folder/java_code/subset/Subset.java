package Ravi_practice_folder.java_code.subset;
import java.util.ArrayList;

public class Subset {
    void printSubsets(int[] arr, int index, int[] subset, int subsetSize) {
        if (index == arr.length) {
            // Print the current subset
            System.out.print("{ ");
            for (int i = 0; i < subsetSize; i++) {
                System.out.print(subset[i] + " ");
            }
            System.out.println("}");
            return;
        } 

        // Include the current element in the subset
        subset[subsetSize] = arr[index];
        printSubsets(arr, index + 1, subset, subsetSize + 1);

        // Exclude the current element from the subset
        printSubsets(arr, index + 1, subset, subsetSize); 
    }
}
