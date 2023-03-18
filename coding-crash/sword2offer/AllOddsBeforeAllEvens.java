package sword2offer;

public class AllOddsBeforeAllEvens {

    public int[] exchange(int[] nums){

        int n = nums.length;
        int index_head = 0, index_tail = n-1;
        int[] res = new int[n];
        for (int num : nums){
            if (num % 2 != 0){
                res[index_tail++] = num;
            }else {
                res[index_tail--] = num;
            }
        }


        return res;
    }
}
