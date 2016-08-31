import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Perceptron {
	
	double learningRate;
	double threshold;
	int numInputs;
	List<Double> weights;
	
	public Perceptron(int numInputs){
		this.numInputs = numInputs;
		this.weights = new ArrayList<Double>(numInputs);
		this.learningRate = .2;
		this.threshold = 1;
		
		//Random initial weights by default
		Random r = new Random();
		for (int i = 0; i< numInputs; i++){
			this.weights.add(r.nextDouble());
		}
	}
	
	public int train(List<Integer> input, int expectedOutput){
		
		int Y = activationLevel(input);
		int error = expectedOutput - Y;
		
		//Update weights if classified the input wrong
		if (error != 0){
			updateWeights(input, error);
		}
		
		if (Main.DEBUG){
			for (int val : input){
				System.out.printf("%-10d", val);
			}
			System.out.printf("%-10d", expectedOutput);
			System.out.printf("%-10d", Y);
			System.out.printf("%-10d", error);
			for (double val : weights){
				System.out.printf("%-10f", val);
			}
			System.out.println();
		}
		
		return error;
	}
	
	private void updateWeights(List<Integer> input, int error){
		
		for (int i = 0; i < weights.size(); i++){
			updateWeight(i, input, error);
		}
	}
	
	private void updateWeight(int i, List<Integer> input, int error){
		weights.set(i, weights.get(i) + learningRate * input.get(i) * error);
	}
	
	private int activationLevel(List<Integer> input){
		return (X(input) > threshold) ? 1 : 0;
	}
	
	private double X(List<Integer> input){
		double sum = 0;
		for (int i = 0; i < input.size(); i++){
			sum += weights.get(i) * input.get(i);
		}
		return sum;
	}
	
	public void setWeights(List<Double> weights){
		this.weights = weights;
	}

	public void setThreshold(double d) {
		threshold = d;
	}

	public void setLearningRate(double learningRate) {
		this.learningRate = learningRate;
	}
	
}
