import java.util.*;

public class FibonacciSumLastDigit {
    
    // the modulus of fibonacci sequence repeats in periods. Pisano period.
    static long pisanoPeriod(long mod){
        long pisano_period = 0;
        long seq_1 = 0;
        long seq_2 = 1;
        
        for(long i =2; i<=(mod*mod); i++){
            long mem = (seq_1 + seq_2)%mod;
            seq_1 = seq_2;
            seq_2 = mem;
            // As soon as the sequence repeats itself break. 
            // Because the modulus sequence is also being fibonacci-ed, so as soon as the first 2 elements become 0 and 1, the cycle repeats again.
            // You keep adding them up and take modulus of it. Don't confuse modulus with the last digit. Modulus is not the last digit, I keep confusing with it.
            if(seq_1 == 0 && seq_2 == 1){
                // it will take one extra step to confirm that the sequence repeated, so i -1; 
                pisano_period = i-1;
                break; 
            }
        }
        return pisano_period;
    }

    public static void main(String[] args){

        // initialize scanner object to read from standard input
        Scanner s = new Scanner(System.in);
        long first = 0;
        long second = 1;
        long period_sum = 0;
        long period_rem_sum = 0;
        long total_sum = 0;
        // read input
        long fibo_len = s.nextLong();
        
        // get Pisano period
        long pisano_period = pisanoPeriod(10);
        long quo = fibo_len/pisano_period;
        long rem = fibo_len - (quo*pisano_period);

        if(fibo_len <= 1){
            System.out.println(fibo_len);
            return;
        }
        
        // pisano remainder sum 
        if(rem>0){
        // to get the sum of first 2 fibo numbers. The loop misses this.
        period_rem_sum = 1;
        for(long i=2; i<=rem; i++){
                long mem = (first + second)%10;
                first = second;
                second = mem;
                period_rem_sum +=second;
            }}
        
        // resetting sequence start
        first = 0;
        second = 1;
        if(fibo_len<=pisano_period){
            total_sum = (period_rem_sum)%10;
        }
        else{ // the entire pisano period sum 
       period_sum = 1;  // to get the sum of first 2 fibo numbers. The loop misses this.
        for(long i=2; i<=pisano_period; i++){
                long mem = (first + second)%10;
                first = second;
                second = mem;
                period_sum +=second;
            }
        total_sum = (period_rem_sum + (quo * period_sum))%10; 
        }
    
        System.out.println(total_sum);
    }}
