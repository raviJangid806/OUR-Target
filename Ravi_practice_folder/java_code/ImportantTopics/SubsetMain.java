

public class SubsetMain {
    public static void main(String[] args) {
        PairSubset pairSubset = new PairSubset();
        int[] nums = {1, 5, 11, 5};

        System.out.println(pairSubset.canPartition(nums));
    }
}
