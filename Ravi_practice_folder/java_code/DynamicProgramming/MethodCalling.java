public class MethodCalling {
    public void method1() {
        DpProblems dpProblems = new DpProblems();
        // int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        // int[] stones = { 0, 1, 3, 6, 10, 13, 14 };
        int[] stones = { 0, 1, 9 };
        boolean canCross = dpProblems.frogJump(stones);
        System.out.println("Can the frog cross the river? " + canCross);
    }
}
