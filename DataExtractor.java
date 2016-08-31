import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataExtractor {
	
	/**
	 * Maps input configurations to outputs of the logical operator.
	 * Eg. for or:
	 * 		[0, 0, 0] -> 0
	 * 		[0, 0, 1] -> 1
	 * 		.
	 * 		.
	 * 		.
	 * @param op			operation
	 * @param numInputs		number of input variables
	 * @return	map resembling a truth table.
	 */
	public HashMap<List<Integer>, Integer> getData(Operation op, int numInputs){
		HashMap<List<Integer>, Integer> map = new HashMap<List<Integer>, Integer>();
		List<List<Integer>> domain = getDomain(numInputs);
		for (List<Integer> config : domain){
			map.put(config, op.perform(config.toArray(new Integer[config.size()])));
		}
		return map;
	}
	
	private List<List<Integer>> getDomain(int numInputs){
		List<List<Integer>> inputs = new ArrayList<List<Integer>>();
		List<Integer> l = new ArrayList<Integer>(numInputs);
		for (int i = 0; i < numInputs; i++){
			l.add(0);
		}
		enumerate(inputs, l, numInputs-1);
		return inputs;
	}
	private void enumerate(List<List<Integer>> inputs, List<Integer> l, int k){
		if (k == -1){
			inputs.add(l);
		}
		else{
			List<Integer> copy = new ArrayList<Integer>(l);
			copy.set(k, not(l.get(k)));
			enumerate(inputs, copy, k-1);
			enumerate(inputs, new ArrayList<Integer>(l), k-1);
		}
	}
	
	private Integer not(Integer a){
		return (a == 0) ? 1 : 0;
	}
}
