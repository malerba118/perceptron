import java.util.List;
import java.util.Map;

public class Trainer {
	
	private Map<List<Integer>, Integer> trainingData;
	private int epochCounter;
	
	public Trainer(Map<List<Integer>, Integer> trainingData){
		this.trainingData = trainingData;
		epochCounter = 1;
	}
	
	public void train(Perceptron p){
		
		if (Main.DEBUG){
			//Just hardcoding the case of 2 inputs and 2 weights
			System.out.printf("%-9s %-9s %-9s %-9s %-9s %-9s %-9s %-9s\n", "Epoch", "X1", "X2", "ExpectedY", "ActualY", "Error", "W1", "W2");
		}
		
		boolean error;
		//loop until an epoch produces no error
		do{
			error = epoch(p);
		}
		while(error);
		
	}
	
	private boolean epoch(Perceptron p){
		
		boolean lingeringError = false;
		
		//train on each instance in the data set
		for (List<Integer> input : trainingData.keySet()){
			if (Main.DEBUG){
				System.out.printf("%-10d", epochCounter);
			}
			int error = p.train(input, outputFor(input));
			if (error != 0){
				lingeringError = true;
			}
		}
		epochCounter++;
		return lingeringError;
	}
	
	private Integer outputFor(List<Integer> input){
		return trainingData.get(input);
	}
}
