package classified.string;

import java.util.Comparator;
import java.util.List;

public class DocSearch {
    // 在一个文本文档中寻找目标记录
    // 全部的记录已经按照关键字做了排序

    public String search(List<String> doc, String target){

        // sort by hashcode(int), then we transformed this problem into a sorted array search problem
        doc.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.hashCode() - o2.hashCode();
            }
        });

        // bi-search
        String[] strs = new String[doc.size()];
        doc.toArray(strs);
        int length = strs.length, left = 0, right = length - 1, mid, compare = target.hashCode();
        while (left <= right){
            mid = (left + right) / 2;
            if (strs[mid].hashCode() < compare){
                right = mid - 1;
            }else if (strs[mid].hashCode() > compare){
                left = mid + 1;
            }else {
                return strs[mid];
            }
        }

        return null;
    }
}
