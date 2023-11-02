import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        return (m/10)+((m%10)/5)+(m%5);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        System.out.println(getChange(m));
    }
}

