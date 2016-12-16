import java.util.Random;
public class Algorithm7 {
    /**
     * Created by farida on 04.11.16.
     */
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
                        HeapSort(A);
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

     //Heap Sorting Algorithm starts here
      public static void HeapSort(int[] H) {
        int i = (H.length - 1) / 2;
        while(i>0){
            MoveDown(H, i, H.length - 1);
            i--;
        }
        for (i = H.length - 1; i > 0; i--) {
            if (H[0] > H[i]) {
                HeapBuilding(H, 0, i);
                MoveDown(H, 0, i - 1);
            }
        }
     }

    private static void MoveDown(int[] H, int first, int last){
        int largest = 2 * first + 1;
        while (largest <= last) {
            if (largest < last && H[largest] < H[largest + 1]) {
                largest++;
            }
            if (H[largest] > H[first]) {
                HeapBuilding(H, largest, first);
                first = largest;
                largest = 2 * first + 1;
            } else {
                return;
            }
        }
    }

    private static void HeapBuilding(int[] H, int a, int b){
        int tmp = H[a];
        H[a] = H[b];
        H[b] = tmp;
    }
 }
