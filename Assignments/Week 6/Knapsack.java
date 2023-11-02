import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] items) {
      // declare the matrix
      int[][] states = new int[W+1][items.length+1];

      // initialize the base cases. Obviously with 0 items the max is 0. 
      // Ok, this is not needed by default java initializes those values to 0
      // for(int i=0; i<=W; i++){
      //   states[i][0] = 0;
      // }
      for(int i=1; i<=W; i++){
        // here you are starting from first item, not from 0 items. The index for the first item is 0.
        for(int j=0; j<items.length; j++){
          int wi = items[j];
          if(wi<=i){
            states[i][j+1] = Math.max(states[i-wi][j] + wi, states[i][j]);
          }
          else states[i][j+1] = states[i][j];
        }
      }
      return states[W][items.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] items = new int[n];
        for (int i = 0; i < n; i++) {
            items[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, items));
    }
}

