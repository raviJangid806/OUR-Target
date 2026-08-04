package Ravi_practice_folder.java_code.subset;

public class SubsetMain {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        Subset subsetGenerator = new Subset();
        int[] subset = new int[arr.length];
        System.out.println("All subsets of the given array:");
        subsetGenerator.printSubsets(arr, 0, subset, 0);
    }
}