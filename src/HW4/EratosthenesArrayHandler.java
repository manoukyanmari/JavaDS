package HW4;
public class EratosthenesArrayHandler {

    //sieveOfEratosthenesRunner Algoritm, exclude als 49*49, 7*7 etc... General all cases until reach of our limit
    public static boolean isPrime(int num) {
        if(num<2) return false;
        //not working solution
        for(int p = 2; p*p <=50; p++)
        {
            // If prime[p] is not changed, then it is a prime

                // Update all multiples of p
                for(int i = p*p; i <= 50; i += p){
                   return false;
                }
            return true;

        }


//working solution
//        for(int i=2; i*i<=num; i++) {
//            if(num%i==0){
//                return false;
//            }
//        }
        return true;
    }

    public static void sieveOfEratosthenesRunner(ArrayList<Integer> list) {
        int secN = 0;
        for (Object num : list) {
            secN +=1;
            int n = (int) num;
            System.out.println(n + "+++");
            if(!isPrime(n)){
                list.remove(secN - 1);
                sieveOfEratosthenesRunner(list);
            }
        }
    }

    public static void main(String[] args) {
        int capacity = 15;
        ArrayList<Integer> list = new ArrayList<Integer>(capacity);
        for(int i=0; i<50; i++) {
            list.add(i,i+1);
        }
        sieveOfEratosthenesRunner(list);
        for (Object ni : list) {
            System.out.printf((int) ni + ", ");
        }
    }
}
