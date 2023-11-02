import java.util.*;

public class FibonacciLastDigit {
    public static void main(String[] args){

        // initialize scanner object to read from standard input
        Scanner s = new Scanner(System.in);
        int first = 0;
        int second = 1;
        // read input
        int fibo_len = s.nextInt();
        if (fibo_len<=1){
            second = fibo_len;
        }
        else{
            for(int i=2; i<=fibo_len; i++){
                int mem = (first + second)%10;
                first = second;
                second = mem;
            }
        }
        System.out.println(second);
    }
}

