
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


class Pair {
    int one;
    int two;
    public Pair(int one, int two) {
        this.one = one; this.two = two;
    }
}

public class Hull {

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int N = scanner.nextInt();
        float[] x = new float[N];
        float[] y = new float[N];
        for (int i = 0; i < N; i += 1) {
            x[i] = scanner.nextFloat();
            y[i] = scanner.nextFloat();
        }

        List<Pair> hullSegments = new ArrayList<Pair>();

        
        //TO DO!!


        System.out.println(hullSegments.size());
        for (Pair p : hullSegments) {
            System.out.printf("%d %d\n", p.one, p.two);
        }
    }

    private static float distance(float x1, float y1, float x2, float y2) {
        float dx = x1 - x2;
        float dy = y1 - y2;
        return dx*dx + dy*dy;
    }
}

