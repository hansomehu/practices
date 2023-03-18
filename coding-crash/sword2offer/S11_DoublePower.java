package sword2offer;

public class S11_DoublePower {
    /**
     *  Given a float base of type double and an integer exponent of type int. Find the exponent power of base.
     *  Library functions must not be used, and large numbers do not need to be considered.
     *
     *  23-bit binary can only represent up to 6 decimal digits
     */

    public double power(double base, int exponent){

        double res = 0;
        if (equal(base,0)) {
            return 0;
        }
        if (exponent == 0) {
            return 1.0; }
        if (exponent > 0) {
            res = multiply(base,exponent);
        }else {
            res = multiply(1/base,-exponent);
        }
        return res;

    }

    public double multiply(double base, int e){
        double sum = 1;
        for (int i = 0; i < e; i++) {
            sum *= base;
        }

        return sum;
    }

    public boolean equal(double a, double b){
        if (a - b < 0.000001 && a - b> -0.000001) return true;
        return false;
    }
}
