package sword2offer;

import java.util.stream.IntStream;

public class S64_Add_From_One_To_N {

    /**
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
     * 使用java8的IntStream ？
     * 使用&& ｜｜ 的短路性质
     */

    public int solution(int n){
        // when n becomes 0, the flag = false will cause a short circuit
        boolean flag = n > 0 && (n += solution(n-1)) > 0; // when n becomes 0, the flag = false will cause a short circuit

        return n;
    }

    public int solution_2(int n){
        return IntStream.range(1, n+1).sum();
    }
}
