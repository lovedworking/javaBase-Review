package algorithm.arrays;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。
 *
 * https://www.nowcoder.com/practice/b56799ebfd684fb394bd315e89324fb4?tpId=188&&tqId=35474&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 */
public class LongestNoRepetition {
    public static void main(String[] args) {
        int[] testarr={4,3,2,5,3,6,8};
        int longest = findLongest(testarr);
        System.out.println(longest);
        int i = maxLength(testarr);
        int max = findMax(testarr);
    }

    //题解一
    public static int findLongest(int[]arr){
        Map<Integer,Integer> map=new LinkedHashMap<>();
        int maxSize=0;
        int i=0;
        while(i<arr.length){
            //发生hash冲突说明前面已经有相同的数了，那个将i移动到前面那个数的位置
            if(map.containsKey(arr[i])){
                maxSize=map.size()<maxSize?maxSize:map.size();
                i=map.get(arr[i]);
                map.clear();
            }else{
                map.put(arr[i],i);
            }
            i++;
        }
        map.forEach((x,y)-> System.out.println(x));
        maxSize=map.size()<maxSize?maxSize:map.size();
        return maxSize;
    }

    //题解二
    public  static int maxLength (int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 1;
        for(int start = 0, end = 0; end<arr.length ; end++){
            if(map.containsKey(arr[end])){
                //重复了
                start = Math.max(start, map.get(arr[end])+1);
                //注意：这里一定要取最大的start，不然就错误了
                //为什么？ 因为重复数字的索引很可能比start小
            }
            max = Math.max(max , end-start+1);
            map.put(arr[end],end);
        }
        map.forEach((x,y)-> System.out.println(x));
        return max;
    }

    //题解三 这个未完全通过 不知和第一个区别在哪
    public static int findMax(int arr[]){
        HashMap<Integer,Integer> map = new  LinkedHashMap<>();
        int maxSize=0;
        for (int i = 0; i <arr.length ; i++) {
            if(map.containsKey(arr[i])){
              maxSize=maxSize>map.size()?maxSize:map.size();
              i=map.get(arr[i]);
              map.clear();
            }else{
                map.put(arr[i],i);
            }
        }
        map.forEach((x,y)-> System.out.println(x));
        return maxSize;
    }




}
