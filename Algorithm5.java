import java.util.Random;

/**
 * Created by farida on 15.10.16.
 */

public class Algorithm5 {

        private static int[] n= new int[]{2,10,100,1000,2000,3000,10000,100000};
        private static int[] m= new int[]{2,10,100,1000,2000,10000,100000};

        //MAIN METHOD
        public static void main(String args[]) throws InterruptedException {
            double avgRunTime=0;
            for(int i=0;i<n.length;i++){
                int[] T= createArray(n[i]);

                for(int k=0; k<m.length;k++){
                    //CREATING STARTING TIME WITH NANOTIME
                    long start = System.nanoTime();
                    int r=5000;
                    for(int j=0; j<r;j++){
                         T=fullfillArray(T,m[k]);
                         InsertionSort(T);
                    }
                    //CREATING ENDING TIME WITH NANOTIME
                    long finish = System.nanoTime()-start;
                    avgRunTime=(finish/r);
                    System.out.println("RunningTime = " + avgRunTime);
                }
            }
            System.out.println("finished");
        }

        //CREATING T ARRAY WITH N SIZE
        public static int[] createArray(int n){
            int[] T=new int[n];
            return T;
        }

        //FULFILLING ARRAY WITH RANDOM VALUES G(T)
        public static int[] fullfillArray(int[] T,int m){
            for(int i=0; i<T.length;i++){
                Random rand = new Random();
                T[i]=rand.nextInt(m);
            }
            return T;
        }

     //INSERTION SORTING ALGORITHM STARTS HERE
      public static void InsertionSort(int[] T) {
        int n = T.length;
        for (int j = 1; j < n; j++) {
            int temp = T[j];
            int i = j-1;
            while ( (i> -1) && (T[i] > temp )) {
                T [i+1] = T [i];
                i--;
            }
            T[i+1]= temp;
        }
    }
}
