import java.util.Random;

/**
 * Created by farida on 22.11.16.
 */
public class Algorithm8 {
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
                        QuickSort(A, 0, A.length-1);
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

        //Quick Sorting Algorithm starts here
        public static void QuickSort(int[] A, int first, int last) {
                    if(first<last){
                        int P = A[last];
                        int l = first;
                        int h = last-1;
                        while (l<h) {
                            if(A[l]<P){
                                l++;
                            }else if(A[h]>=P){
                                h--;
                            }else{
                                int tmp = A[h];
                                A[h]=A[l];
                                A[l] = tmp;
                                h--;
                                l++;
                            }
                        }
                        if(l==h){
                            if(A[l]>=P){
                                h--;
                            }else{
                                l++;
                            }
                        }
                           if(h==first-1){
                            int tmp = A[first];
                            A[first]=A[last];
                            A[last] = tmp;
                            l=first+1;
                            h=first;
                            }else{
                            A[last]=A[h+1];
                            }
                        try{
                            // Recursion
                                QuickSort(A,first,h);
                                QuickSort(A,l,last);
                        }catch (StackOverflowError ex){
                            ex.printStackTrace();
                        }
                        }
                }
           }
