import java.io.*;
import java.util.*;

public class BinarySearchWithDuplicates {

    static int binarySearch(int[] a, int x, int left, int right, int min_idx) {
        //write your code here
        if(right<left) return min_idx;

        int mid = (left + right)/2;
        if(x == a[mid]){
            min_idx = mid;
            return binarySearch(a, x, left, mid-1, min_idx);
        }
        else if(x>a[mid]) return binarySearch(a, x, mid+1, right, min_idx);
        else return binarySearch(a, x, left, mid-1, min_idx);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(binarySearch(a, b[i], 0, (a.length-1), -1) + " ");
        }
    }
}
