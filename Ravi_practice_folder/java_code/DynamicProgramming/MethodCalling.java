public class MethodCalling {
    public void method1() {
        DpProblems dpProblems = new DpProblems();
        System.out.print(dpProblems.findTargetSumWays(new int[] { 1, 1, 1, 1, 1 }, 3));
        System.out.print(dpProblems.findTargetSumWays(new int[] { 1, 1, 2, 1, 1 }, 3));

    }
}
