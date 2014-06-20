package recursion;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by curtiskroetsch on 2014-06-16.
 */
public interface RecursiveFunction<Input,Output> {

    public boolean isBaseCase(Input input);

    public Output getBaseCaseResult(Input input);

    public Output collectResults(Output[] outputs);

    public Input[] getSubProblems(Input input);

    public Input getStartInput();

    public Output[] newOutputArray(int size);



}
