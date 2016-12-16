import java.util.Random;

/**
 * Created by farida on 15.10.16.
 */
public class Algorithm4 {

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
                    int r=1;
                    for(int j=0; j<r;j++){
                        T=fullfillArray(T,m[k]);
                        bubbleSort(T);
                    }
                    //CREATING ENDING TIME WITH NANOTIME
                    long finish = System.nanoTime()-start;
                    avgRunTime= (finish/r);
                    System.out.println("RunningTime = "+  avgRunTime);
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


     //BUBBLE SORTING ALGORITHM STARTS HERE
   /* private static void BubbleSorting(int[] T) {
        int temp = 0;
        for(int i=0; i < T.length-1; i++){
          // for(int j=1; j < (T.length-i); j++){
            int j=T.length-i;
            while(i<j){
                if(T[j] <T[j-1]){
                    temp = T[j];
                    T[j] = T[j-1];
                   T[j-1] = temp;
                 //   T[j]=T[j-1];
                }
                j--;
            }
            i++;
            //}
        }
    }*/

    public static void bubbleSort(int[] numArray) {
        int n = numArray.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (numArray[j] < numArray[j-1]) {
                    temp = numArray[j - 1];
                    numArray[j - 1] = numArray[j];
                    numArray[j] = temp;
                }
            }
        }
    }


    //BUBBLE SORTING ALGORITHM STARTS HERE
 /*   private static void BubbleSorting(int[] T) {
        int temp = 0;
        for(int i=0; i < T.length; i++){
            for(int j=1; j < (T.length-i); j++){
                if(T[j-1] > T[j]){
                    temp = T[j-1];
                    T[j-1] = T[j];
                    T[j] = temp;
                }
            }
        }
    }*/
}
