import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by farida on 04.12.16.
 */
public class Algorithm10 {
        private static int[] n= new int[]{2,10,100,1000,2000,3000,10000,100000};
        private static int[] m= new int[]{2,10,100,1000,2000,10000,100000};

        //MAIN METHOD
        public static void main(String args[]) throws InterruptedException {
            double avgRunTime=0;
            for(int i=0;i<n.length;i++){
                int[] A= createArray(n[i]);
                for(int k=0; k<m.length;k++){
                    //CREATING STARTING TIME WITH NANOTIME
                    long start = System.nanoTime();
                    int r=1;
                    for(int j=0; j<r;j++){
                        A=fullfillArray(A,m[k]);
                        radix_sort(A,A.length,3,3);
                    }
                    //CREATING ENDING TIME WITH NANOTIME
                    long finish = System.nanoTime()-start;
                    avgRunTime= (finish/r);
                    System.out.println("RunningTime = "+  avgRunTime);
                }
            }
            System.out.println("finished");
        }


    //CREATING A ARRAY WITH N SIZE
        public static int[] createArray(int n){
            int[] A = new int[n];
            return A;
        }

        //FULFILLING ARRAY WITH RANDOM VALUES G(A)
        public static int[] fullfillArray(int[] A,int m){
            for(int i=0; i<A.length;i++){
                Random rand = new Random();
                A[i]=rand.nextInt(m);
            }
            return A;
        }
 ///RADIX SORT
    public static void radix_sort( int[] A,int n,int g,int k)
    {
        List<Integer>[] bucket = new ArrayList[g];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<Integer>();
        }
        boolean maxLength = false;
        int tmp = -1, placement = 1;
        while (!maxLength) {
            maxLength = true;
            for (Integer i : A) {
                tmp = i / placement;
                bucket[tmp % g].add(i);
                if (maxLength && tmp > 0) {
                    maxLength = false;
                }
            }
            int a = 0;
            for (int b = 0; b < g; b++) {
                for (Integer i : bucket[b]) {
                    A[a++] = i;
                }
                bucket[b].clear();
            }
            placement *= g;
        }
    }
}