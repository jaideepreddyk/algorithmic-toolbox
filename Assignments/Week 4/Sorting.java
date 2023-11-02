import java.io.*;
import java.util.*;

public class Sorting {
    static int[] partition(int[] a, int lower, int upper){
        int[] pivot_ranges = new int[2];
        int temp;
            // mid-point
            int pivot_left = (upper+lower)/2;
            int pivot_right = pivot_left;
            // quick sort firt pass
            for(int i=lower; i<upper; i++){
                //equal to case
                    if(a[i]==a[pivot_left] & i<pivot_left){
                        temp = a[i];
                        a[i] = a[pivot_left-1];
                        a[pivot_left-1] = temp;
                        pivot_left-=1;
                    }
                    else if(a[i]==a[pivot_right] & i>pivot_right){
                        temp = a[i];
                        a[i] = a[pivot_right+1];
                        a[pivot_right+1] = temp;
                        pivot_right+=1;
                    }
                // greater than case
                if(a[i]>a[pivot_left] & i<pivot_left){
                    temp = a[i];
                    a[i] = a[pivot_left];
                    a[pivot_left] = temp;
                    pivot_left = i;
                    //reset pivot range
                    pivot_right = pivot_left;

                }
                // less than case
                else if(a[i]<a[pivot_right] & i>pivot_right){
                    //swap 1
                    temp = a[i];
                    a[i] = a[pivot_right+1];
                    a[pivot_right+1] = temp;
                    //swap 2
                    temp = a[pivot_left];
                    a[pivot_left] = a[pivot_right+1];
                    a[pivot_right+1]=temp;
                    //increment indexes to account for the shift
                    pivot_left+=1;
                    pivot_right+=1; 
                }
            }
        pivot_ranges[0] = pivot_left;
        pivot_ranges[1] = pivot_right;
        return pivot_ranges;
    }

    static int[] randomizedQuickSort(int[] a, int lower, int upper){
        if(upper-lower>1){
            int[] pivot_ranges = partition(a, lower, upper);
            randomizedQuickSort(a, lower, pivot_ranges[0]);
            randomizedQuickSort(a, pivot_ranges[1]+1, upper);
        }
        return a;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

