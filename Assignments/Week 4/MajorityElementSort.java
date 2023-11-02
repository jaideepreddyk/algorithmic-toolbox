import java.util.Arrays;
import java.util.Scanner;

public class MajorityElementSort {

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

    static int[] quickSort(int[] a, int lower, int upper){
        if(upper-lower>1){
            int[] pivot_ranges = partition(a, lower, upper);
            quickSort(a, lower, pivot_ranges[0]);
            quickSort(a, pivot_ranges[1]+1, upper);
        }
        return a;
    }

    private static int getMajorityElement(int[] a, int left, int right) {
        
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return -1;
        }
        a = quickSort(a, left, right);
        double upper_limit = (Double)(a.length/2.0);
        for(int i=0; i<Math.ceil(upper_limit);i++){
            if(a[i]==a[i+(a.length/2)]){
                return a[i];
            }
        }
        return -1;
    }    
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
