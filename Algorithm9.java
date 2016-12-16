import java.util.Random;

/**
 * Created by farida on 04.12.16.
 */
public class Algorithm9 {
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
                    int r=5000;
                    for(int j=0; j<r;j++){
                        A=fullfillArray(A,m[k]);
                        try{
                            count_sort(A,n,A.length);
                        }catch(Exception e){};

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

       /////COUNTING SORTING starts here///
    public static void count_sort(int A[],int B[],int k){
            int[] C=new int[k];
            for(int j=0;j<A.length;j++){
                C[A[j]]=C[A[j]]+1;
            }
            for(int i=1;i<k;i++){
                C[i]=C[i]+C[i-1];
            }
            for(int j=(A.length-1);j>=0;j--){
                B[C[A[j]]-1]=A[j];
                C[A[j]]=C[A[j]]-1;
            }
        }
}
