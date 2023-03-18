package sword2offer;

/**
 * @author hanson.hu
 */
public class S14_CuttingRope {
    // 一根长n的绳子剪成m(m1, m2, ....)段,求m1 * m2 * m3 ...的最大值
    // n,m > 1

    /**
     * 找到最大情况的临界情况为3，即最小段长为3的时候乘积会最大
     */

    public int solve(int n){
        // if(n <= 3) return n - 1;
        // int a = n / 3, b = n % 3;
        // if(b == 0) return (int)Math.pow(3, a) * 4/4;
        // if(b == 1) return (int)Math.pow(3, a)* 4/3;
        // return (int)Math.pow(3, a) * 4/2;

        return n <= 3 ? n-1 : (int)Math.pow(3, n/3) * 4/(4 - n % 3);
    }
}
