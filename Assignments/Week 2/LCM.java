import java.util.*;

public class LCM {
  static long gcd(long a, long b){
    if(b==0){
        return a;
    }
    else{
        long ans = gcd(b, a%b);
        return ans;
    }
}

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    long a = scanner.nextInt();
    long b = scanner.nextInt();

    long lcm = 1;
    long gcd_result;

    while(gcd(a, b)>1){
      gcd_result = gcd(a, b);
      a = a/gcd_result;
      b= b/gcd_result;
      lcm *= gcd_result;
    }
    System.out.println(lcm*a*b);

  }
}
