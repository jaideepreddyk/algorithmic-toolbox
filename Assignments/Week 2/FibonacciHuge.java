import java.util.*;

public class FibonacciHuge {
    
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
        // read input
        long fibo_len = s.nextLong();
        long mod = s.nextInt();
        
        // get Pisano period
        long pisano_period = pisanoPeriod(mod);
        long pisano_position = fibo_len%pisano_period;

        if (pisano_position<=1){
            second = pisano_position;
        }
        else{
            for(long i=2; i<=fibo_len%pisano_period; i++){
                long mem = (first + second)%mod;
                first = second;
                second = mem;
            }
        }
        System.out.println(second);
    }
}

