package recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by curtiskroetsch on 2014-06-16.
 */
public class RecursiveFunctionSolver {

    public static  <Input, Output> Output solve(RecursiveFunction<Input, Output> func) {

        return recurse(func, func.getStartInput());
    }

    private static <Input, Output> Output recurse(RecursiveFunction<Input, Output> func, Input input) {

        if (func.isBaseCase(input)) {
            return func.getBaseCaseResult(input);
        }

        Input[] subProblems = func.getSubProblems(input);
        Output[] results = func.newOutputArray(subProblems.length);
        for (int i=0; i < subProblems.length; i++) {
            results[i] = recurse(func, subProblems[i]);
        }

        return func.collectResults(results);
    }

    public static <Input, Output> Output solveWithMemoization(RecursiveFunction<Input, Output> func) {

        Map<Input, Output> mem = new HashMap<Input, Output>();
        return recurseWithMem(func, mem, func.getStartInput());
    }

    private static  <Input, Output> Output recurseWithMem(RecursiveFunction<Input, Output> func, Map<Input, Output> mem, Input input) {

        if (mem.containsKey(input)) {
            return mem.get(input);
        } else if (func.isBaseCase(input)) {
            return func.getBaseCaseResult(input);
        }

        Input[] subProblems = func.getSubProblems(input);
        Output[] results = func.newOutputArray(subProblems.length);
        for (int i=0; i < subProblems.length; i++) {
            results[i] = recurseWithMem(func, mem, subProblems[i]);
        }

        Output r = func.collectResults(results);
        mem.put(input, r);
        return r;
    }

}
