import java.util.Random;

/**
 * Created by faridaa on 23.09.16.
 */
public class Algorithm1 {
      private static int[] n= new int[]{2,10,100,1000,2000,3000,10000,100000};
      private static int[] m= new int[]{2,10,100,1000,2000,10000,100000,1000000};

    //MAIN METHOD
        public static void main(String args[]) throws InterruptedException {
            double avgRunTime=0;

            //CREATING STARTING TIME WITH NANOTIME
            long start = System.nanoTime();
            int r=5000;
            for(int j=0; j<r;j++){
            for(int i=0;i<n.length;i++){
             int[] T= createArray(n[i]);
             T=fullfillArray(T,m[i]);
                    int a=generateA(m[i]);
                    System.out.println("Random variable = "+a);
                    //SEARCHING STARTS HERE
                    searchingA(T, a);
                  }
             }

            //CREATING ENDING TIME WITH NANOTIME
            long finish = System.nanoTime()-start;
               avgRunTime= (finish/r);
            //RESULT OF AVERAGE RUNNING TIME WITH SECONDS
            System.out.format("RunningTime = "+ "%f%n", avgRunTime/1000000000);

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

      //GENERATING RANDOM VALUE a
      public static int generateA(int m){
          Random rand = new Random();
          return rand.nextInt(m);
      }

      //SEARCHING a VALUE IN T ARRAY
      public static int searchingA(int[] T, int a){
              for( int i=0;i<T.length;i++){
                  if(T[i]==a){
                      //IF THE VALUE IS IN ARRAY COMES HERE
                      System.out.println("Included to array "+a);
                  }else{
                      //IF THE VALUE IS NOT IN ARRAY COMES HERE
                   //  System.out.println("Not included to array "+a);
                  }
              }
          return a;
      }
}
