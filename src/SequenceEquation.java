import java.util.Scanner;

public class SequenceEquation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] p = new int[55];
        for (int i=0; i<size; i++)
            p[i] = scanner.nextInt();
        for (int x=1; x<=size; x++) {
            for (int j=0; j<size; j++) {
                if (p[j] == x) {
                    for (int k=0; k<size; k++) {
                        if (p[k] == j+1) {
                            System.out.println(k+1);
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }
}
