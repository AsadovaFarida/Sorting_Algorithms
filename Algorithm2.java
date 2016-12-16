import java.util.Random;

/**
 * Created by faridaa on 06.10.16.
 */
public class Algorithm2 {
    private static int[] n= new int[]{2,10,100,1000,2000,3000,10000,100000};
    private static int[] m= new int[]{2,10,100,1000,2000,10000,100000};

    //MAIN METHOD
    public static void main(String args[]) throws InterruptedException {
        double avgRunTime=0;

        //CREATING STARTING TIME WITH NANOTIME
        long start = System.nanoTime();
        int r=5000;
        for(int j=0; j<r;j++){
            for(int i=0;i<n.length;i++){
                int[] T= createArray(n[i]);
                for(int k=0; k<m.length;k++){
                    T=fullfillArray(T,m[k]);
                    minSelection(T);
                }
            }
        }

        //CREATING ENDING TIME WITH NANOTIME
        long finish = System.nanoTime()-start;
        avgRunTime= (finish/r);
        //RESULT OF AVERAGE RUNNING TIME WITH NANOSECONDS
        System.out.format("RunningTime = "+ avgRunTime);
    }


    //CREATING T ARRAY WITH N SIZE
    public static int[] createArray(int n){
        int[] T=new int[n-1];
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

   ////Minimum Selecting starts here
    public static int minSelection( int[] T){
        int minimum= T[0];
        for(int i=0; i<T.length;i++){
            if(minimum>T[i]){
                minimum=T[i];
            }
        }
        return minimum;
    }


}
