package algorithm.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**剑指offer编程题
 * https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=13&tqId=11190&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * 统计一个数字在升序数组中出现的次数。
 * Input:
 * nums = 1, 2, 3, 3, 3, 3, 4, 6
 * K = 3
 * Output:
 * 4
 *
 */


public class GetNumCountInSortedArray {

    public static void main(String[] args) {
        int[] test={1, 2, 3, 3, 3, 3, 5, 6};
        int k=3;
        int kCount = getKCount(test, 3);
        System.out.println(kCount);
        int numByBinarySearch = getNumByBinarySearch(test, k);
        System.out.println(kCount);
    }
    //最傻逼的遍历
    public static int getKCount(int [] array,int k){
        int retCount=0;
        HashMap<Integer, Integer> frequentMap = new HashMap<>();
        Arrays.stream(array).forEach(num->{
            frequentMap.put(num,frequentMap.getOrDefault(num,0)+1);
        });
        retCount=frequentMap.getOrDefault(k,0);
        return retCount;
    }

    public static int getNumByBinarySearch(int [] array,int k){
        int first = binarySearch(array, k);
        int last = binarySearch(array, k + 1);
        return (first == array.length || array[first] != k) ? 0 : last - first;
    }
    //二分查找搜索
    public static int binarySearch(int [] array,int k){
        int l=0,h=array.length;
        while(l<h){
            int mid = l+(h-l)/2;
            if(array[mid]>=k){
                h=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }

}
