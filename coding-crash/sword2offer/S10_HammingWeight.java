package sword2offer;

public class S10_HammingWeight {

    public int hammingWeight(int n){
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) count++;
        }

        return count;
    }
}
