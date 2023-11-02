import java.util.*;
import java.io.*;

public class Partition3 {

    static int arraySum(int[] arr){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }

    static int[] arrayRemove(int[] arr, int del){
        int[] new_arr = new int[arr.length];
        int j = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=del){
                new_arr[j] = arr[i];
                j++;
            }
        }
        return new_arr;
    }

    static int[][] Knapsack(int W, int[] items) {
        // declare the matrix
        int[][] states = new int[W+1][items.length+1];
  
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
        return states;
    }

    static int[] tracer_remaining(int[][] states, int[] items, int w){
        int[] track = new int[items.length];
        int counter = 0;
        for(int i=items.length; i>=1; i--){
            if(states[w][i-1]<states[w][i]){
                w = w - items[i-1];
            }
            else{
                track[counter] = items[i-1];
                counter++;
            }
        }
        return track;
    }

    static int[] tracer_used(int[][] states, int[] items, int w){
        int[] track = new int[items.length];
        int counter = 0;
        for(int i=items.length; i>=1; i--){
            if(states[w][i-1]<states[w][i]){
                w = w - items[i-1];
                track[counter] = items[i-1];
                counter++;
            }
        }
        return track;
    }

    private static int partition3(int[] A) {
        //write your code here
        int sum = arraySum(A);
        if(sum%3!=0) return 0;

        // first knapsack
        int[][] state1 = Knapsack(sum/3, A);
        if(state1[sum/3][A.length]<sum/3) return 0;
        int[] remaining = tracer_remaining(state1, A, sum/3);
        int[] used = tracer_used(state1, A, sum/3);

        // second knapsack
        int idx = 0;
        int del = used[0];
        int[][] state2 = Knapsack(sum/3, remaining);
        if(state2[sum/3][remaining.length]<sum/3) {
            if(arraySum(remaining)/2==sum/3){
                int[] APrime = arrayRemove(A, del);
                state1 = Knapsack(sum/3, APrime);
                remaining = tracer_remaining(state1, APrime, sum/3);
                used = tracer_remaining(state1, APrime, sum/3);
                idx = APrime.length - used.length;
                remaining[idx] = del;
                state2 = Knapsack(sum/3, remaining);
            }
        }
        
        int[] mid_remaining = tracer_remaining(state2, remaining, sum/3);

        // third knapsack
        int[][] state3 = Knapsack(sum/3, mid_remaining);
        if(state3[sum/3][mid_remaining.length]<sum/3) return 0;

        return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n<3){
            System.out.println(0);
        }
        else{
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = scanner.nextInt();
            }
            System.out.println(partition3(A));
        }
    }
}

