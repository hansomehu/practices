package sword2offer;

public class S09_Fibonacci {
    /**
     *   fib problem and its alike. e.g frogs step stairs
     *
     */

    public int fibonacciInLoop(int n) {
        int one = 1;
        int two = 2;
        int res = 0;

        if(n == 1 || n == 0) return one;
        if(n == 2) return two;

        if(n > 2){
            for(int i=3; i<=n; i++){
                // remind of overflow
                res = (one + two)%1000000007;
                one = two%1000000007;
                two = res;
            }
            return res;
        }

        return 0;

    }
}
