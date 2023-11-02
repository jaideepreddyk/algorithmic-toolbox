import java.util.Scanner;

public class MaxPairwiseProduct {

    static long maxProduct(int len, Scanner sc){
        //declare 
        long first = sc.nextInt();
        long second = sc.nextInt();
        long product = first * second;
        long max = Long.max(first, second);
        int i = len - 2;
        
        // loop and read the input
        while(i>0)
        {   
            // because a min of 2 numbers are passed you can safely create 2 slots for operands
            int new_num = sc.nextInt();
            if(new_num*max>product){
                product = new_num*max;
                max = Long.max(max, new_num);
            }
            i--;
        }
        return product;
    }

    public static void main(String[] args){
        // decalre scanner
        Scanner s = new Scanner(System.in);
        // scanning length of array
        int arr_len = s.nextInt();
        // declare the array to store sequence
        long answer = maxProduct(arr_len, s);
        System.out.println(answer);
    }
}
