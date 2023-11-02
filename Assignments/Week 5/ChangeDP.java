import java.util.Arrays;
import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        int op4; int op3; int op1;
        int[] total = new int[m+4];
        Arrays.fill(total,0);
        total[1] = 1; total[2] = 2; total[3] = 1; total[4] = 1;

        for(int i=5; i<=m; i++){
            op4 = total[i-4] ;
            op3 = total[i-3] ;
            op1 = total[i-1];
            total[i] = Math.min(Math.min(op4, op3), op1) + 1;
        }
        return total[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

