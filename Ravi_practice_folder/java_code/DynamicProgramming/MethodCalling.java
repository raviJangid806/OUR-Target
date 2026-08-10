public class MethodCalling {
    public void method1() {
        DpProblems dpProblems = new DpProblems();
        DpExampleSet dpExampleSet = new DpExampleSet();
        int[][] exampleSet = dpExampleSet.getArrayOfArray();
        System.out.println("Example Set:");
        // leetcode Question: 198. House Robber
        // int[] nums = {1,2,1,1};
        for(int[] nums: exampleSet){
            System.out.println("Input Array: " + java.util.Arrays.toString(nums));
            System.out.println("Maximum amount that can be robbed: " + dpProblems.rob(nums));
        }   
        // System.out.println("Maximum amount that can be robbed: " + dpProblems.rob(nums));
    }
}
 