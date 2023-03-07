
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
        //make scanner
        Scanner scanner =  new Scanner(System.in);
        //get number of pairs
        System.out.println("Enter amount of points:");
        int N = scanner.nextInt();
        //init arrays to hold the floats
        float[] x = new float[N];
        float[] y = new float[N];
        //get the x and y values defined by the amount of times it was called
        for (int i = 0; i < N; i += 1) {
            x[i] = scanner.nextFloat();
            y[i] = scanner.nextFloat();
        }
        scanner.close();
        
        //init the boundary as empty
        List<Pair> hullSegments = new ArrayList<Pair>();
        
        //TO DO!!
        //init counts
        int bound_less, bound_more;
        //for each x
        for(int i=0; i<x.length; i+=1){
            //for each y
            for(int j=0; j<x.length; j+=1){
                boolean valid = true;
                bound_less =0; bound_more = 0;
                //get a = y2 - y1
                float a = y[j] - y[i];
                //get b = x1 - x2
                float b = x[i] - x[j];
                //get c = x1y2 - y1x2
                float c = (x[i]*y[j]) - (y[i]*x[j]);
                //for each combination of points on the set
                for(int k=0; k<x.length; k+=1){
                    //see how a(xi) + b(yi) compare to c
                    //if a(xi) + b(yi) < c
                    if ((a*x[k]) + (b*y[k]) < c){
                        //add to bound_less
                        bound_less++;
                    }
                    //else if a(xi) + b(yi) > c
                    else if((a*x[k]) + (b*y[k]) > c){
                        //add to bound_more
                        bound_more++;
                    } 
                    else if((a*x[k]) +(b*y[k])==c){
                        //check if midpoint
                        
                        float distIJ = distance(x[i], y[i], x[j], y[j]);
                        float distIK = distance(x[i], y[i], x[k], y[k]);
                        float distJK = distance(x[j], y[j], x[k], y[k]);
                        if((distIJ < distIK) | (distIJ < distJK)){
                            valid = false;
                        }
                    }
                }
                //if all points are less than segment it is boundary and add to hull segments    
                if ((bound_less < 0) & (bound_more == 0)){
                    //if distance between i and j is less than i and k
                    //or
                    //if distance between i adn j is less than j and k
                    if(valid){
                        hullSegments.add(new Pair(i,j));

                    }
                }
                //if all points are more than segment then add to boundary          
                else if((bound_more > 0) & (bound_less == 0)){
                    if(valid){
                        hullSegments.add(new Pair(i,j));

                    }
                }
                // else{
                //     System.out.println("THEY EQUAL");
                // }
            }
        }    


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

