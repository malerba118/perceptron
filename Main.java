import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Super overkill solution, sorry about that.
 * I wanted to practice my OOP skills.
 * 
 * @author austin malerba - abm6121
 *
 */
public class Main {
	
	//Allows for printing of output
	public static boolean DEBUG = true;

	public static void main(String[] args) {

		if (args.length != 5){
			usage();
		}
		
		double threshold = Double.parseDouble(args[0]);
		double learningRate = Double.parseDouble(args[1]);
		double w1 = Double.parseDouble(args[2]);
		double w2 = Double.parseDouble(args[3]);
		String opArg = args[4];
		
		Operation operation = null;
		
		if (opArg.equals("OR")){
			operation = new Or();
		}
		else if (opArg.equals("AND")){
			operation = new And();
		}
		else if (opArg.equals("XOR")){
			operation = new Xor();
		}
		else{
			usage();
		}
		
		//Turn logical operator into truth table with 2 inputs
		DataExtractor extractor = new DataExtractor();
		Map<List<Integer>, Integer> trainingData = extractor.getData(operation, 2);
		
		//Initialize perceptron with 2 inputs
		Perceptron p = new Perceptron(2);
		List<Double> initWeights = new ArrayList<Double>();
		initWeights.add(w1);
		initWeights.add(w2);
		p.setWeights(initWeights);
		p.setThreshold(threshold);
		p.setLearningRate(learningRate);
		
		//Train perceptron
		Trainer trainer = new Trainer(trainingData);
		trainer.train(p);
		
	}

	private static class Or implements Operation{

		@Override
		public Integer perform(Integer... args) {
			// TODO Auto-generated method stub
			for (Integer arg : args)
				if (arg != 0) {
					return 1;
				}
			return 0;
		}
		
	}
	
	private static class And implements Operation{

		@Override
		public Integer perform(Integer... args) {
			// TODO Auto-generated method stub
			for (Integer arg : args)
				if (arg == 0) {
					return 0;
				}
			return 1;
		}
		
	}
	
	private static class Xor implements Operation{

		@Override
		public Integer perform(Integer... args) {
			// TODO Auto-generated method stub
			int trueCount = 0;
			for (Integer arg : args){
				if (arg != 0){
					trueCount++;
				}
			}
			return ((trueCount % 2) == 0) ? 0 : 1;
		}
		
	}
	
	public static void usage(){
		System.err.println("Usage: java Main <threshold> <learningRate> <weight1> <weight2> <operation>");
		System.exit(1);
	}
}
