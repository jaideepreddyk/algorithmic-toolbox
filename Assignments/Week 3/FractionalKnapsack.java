import java.util.Scanner;

public class FractionalKnapsack {

    private static int bestItem(double[] values, double[] weights){
        int best_item =0;
        double max_rate=0;
        for(int i=0; i<values.length;i++){
            if (weights[i]>0){
                if (values[i]/weights[i]>max_rate){
                    max_rate = values[i]/weights[i];
                    best_item = i;
                }
            }
        }
        return best_item;
    }
    private static double getOptimalValue(double capacity, double[] values, double[] weights) {
        double value = 0;
        //write your code here
        for(int i=0; i<values.length; i++){
            if(capacity==0) return value;
            int index = bestItem(values, weights);
            double amount = Math.min(weights[index], capacity);
            value = value +(amount *(values[index]/weights[index]));
            weights[index] = weights[index] - amount;
            capacity = capacity - amount;
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double capacity = scanner.nextDouble();
        double[] values = new double[n];
        double[] weights = new double[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextDouble();
            weights[i] = scanner.nextDouble();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
