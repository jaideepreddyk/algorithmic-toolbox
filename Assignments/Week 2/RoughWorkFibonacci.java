import java.util.Scanner;

public class RoughWorkFibonacci {
    public static void main(String[] args){

        // initialize scanner object to read from standard input
        Scanner s = new Scanner(System.in);
        long first = 0;
        long second = 1;
        // read input
        int fibo_len = s.nextInt();
        if (fibo_len<=1){
            second = fibo_len;
        }
        else{
            for(int i=2; i<=fibo_len; i++){
                long mem = first + second;
                first = second;
                second = mem;
            }
        }
        System.out.println(second);
    }
}
