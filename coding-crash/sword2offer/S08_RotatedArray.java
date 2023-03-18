package sword2offer;

public class S08_RotatedArray {

    public int solution(int[] rotatedArray){
        if (rotatedArray.length == 0) return 0;

        int low = 0;
        int high = rotatedArray.length - 1;

        while (low < high){
            int pos = low + (high - low)/2;
            if (rotatedArray[pos] < rotatedArray[high]) high = pos;
            // we need the new low be the previous pos, since in java "/" operation will automatically round down, thus +1
            if (rotatedArray[pos] > rotatedArray[high]) low = pos + 1;
            else high--;
        }
        return rotatedArray[low];

    }
}
