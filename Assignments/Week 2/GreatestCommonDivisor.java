import java.util.Scanner;

public class GreatestCommonDivisor {
// Euclidean Algorithm
// GCD(a, b) = GCD(a', b) = GCD(b, a') 
// because a = a' + qb  (a' is the remainder and q is the quotient). Therefore if some 'd' divides a and b it can only happen if it divides a'
// where a' is the remainder of a/b
// base case : GCD(a,b), when b = 0, is a.
// because 0 is divisible by everything and therefore the value of 'a' will be the GCD. 
// Because if 0 is divisible by everything, then it will also be divisible by the maximum possible value that 'a' is divisible with....itself!

    static long gcd(long a, long b){
        if(b==0){
            return a;
        }
        else{
            long ans = gcd(b, a%b);
            return ans;
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        long first = s.nextLong();
        long second = s.nextLong();
        long result = gcd(first, second);
        System.out.println(result);
    }
}

