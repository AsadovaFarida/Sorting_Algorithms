import java.util.Arrays;
import java.util.Random;

/**
 * Created by farida on 21.10.16.
 */
public class Algorithm6 {

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
                        A=MergeSort(A, A.length);
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
            int[] A=new int[n];
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


       //MERGESORT METHOD STARTS HERE
        private static int[] MergeSort(int[] A,int n){
           if(n<=2){
               if((n==2)&&(A[0]>A[1])){
                  int temp = A[0];
                   A[0] = A[1];
                   A[1] = temp;
               }
               return A;
           }else{
               int k=n/2;
               //SPLITTING ARRAY AND MERGING
              int[] A1=MergeSort(Arrays.copyOfRange(A, 0, k),k);
              int[] A2=MergeSort(Arrays.copyOfRange(A,k,n),n-k);
              A=Merge(A1,k,A2,n-k);
              return A;
           }

        }


    //MERGING ARRAY METHOD
    private static int[] Merge(int[] A1, int n1, int[] A2, int n2){
        int[] A = new int[n1+n2];
        int i=0, j=0;
        while((i<n1)&&(j<n2)){
            if(A1[i]<A2[j]){
                A[i+j]=A1[i];
                i++;
            }else{
                A[i+j]=A2[j];
                j++;
            }
        }
        if(i==n1){
            while(j<n2){
                A[i+j]=A2[j];
                j++;
            }
        } else{
            while(i<n1){
                A[i+j]=A1[i];
                i++;
            }
        }
     return A;
    }
}
