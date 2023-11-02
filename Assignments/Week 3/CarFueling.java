import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops, int n) {
        
        int gas_stops = 0;
        if (stops[0]>tank) return -1;
        int dist_to_empty = tank - stops[0];

        // make a new array appending 0 and the end point(dist)
        int new_len = n+2;
        int[] stops_real = new int[new_len];
        int last_idx = new_len-1;
        // adding start and end points to stops
        stops_real[0] = 0;
        stops_real[last_idx] = dist;
        // adding the gas station locations to the stops real array
        for(int j=0; j<last_idx-1; j++){
            stops_real[j+1] = stops[j];
        }

        for(int i=1; i<last_idx; i++){
            // we are looking ahead here
            if(stops_real[i+1]-stops_real[i]>dist_to_empty){
                gas_stops++; 
                dist_to_empty = tank;
            }
            if(stops_real[i+1]-stops_real[i]>dist_to_empty) return -1;
            //we go forward after making decision to quit or refill
            dist_to_empty = dist_to_empty - (stops_real[i+1]-stops_real[i]);
        }
        return gas_stops;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops, n));
    }
}
