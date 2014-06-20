package examples;

import recursion.RecursiveFunction;
import recursion.RecursiveFunctionSolver;


/**
 * Created by curtiskroetsch on 2014-06-16.
 */
public class Fibb implements RecursiveFunction<Integer,Integer> {

    final int start;

    public Fibb(int x) {
        this.start = x;
    }

    @Override
    public boolean isBaseCase(Integer integer) {
        return (integer < 2);
    }

    @Override
    public Integer getBaseCaseResult(Integer integer) {
        return 1;
    }

    @Override
    public Integer collectResults(Integer[] integers) {

        int sum = 0;
        for (Integer i : integers) {
            sum += i;
        }

        return sum;
    }

    @Override
    public Integer[] getSubProblems(Integer integer) {
        return new Integer[] { integer-1, integer-2 };
    }

    @Override
    public Integer getStartInput() {
        return start;
    }

    @Override
    public Integer[] newOutputArray(int size) {
        return new Integer[size];
    }

    public static void main(String args[])  {

        Fibb fibb = new Fibb(44);

        Integer result = RecursiveFunctionSolver.solveWithMemoization(fibb);

        System.out.println(result);

    }
}
