package interview150;

public class S134_GasStation {
    /*
    https://leetcode.cn/problems/gas-station/description/?envType=study-plan-v2&id=top-interview-150
     */
    private int solution(int[] gas, int[] cost){
        int n = gas.length;
        int i = 0;
        while (i < n){
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;

            while (cnt < n){
                int j = (i + cnt) % n; // current index
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfGas < sumOfCost) break;

                cnt++;
            }

            if (cnt == n){
                return i;
            }else {
                i = i + cnt + 1; // update the next possible reachable station
            }
        }

        return -1;
    }
}
