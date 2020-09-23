package algorithm.sort;

import java.util.*;

/**
 * 桶排序
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 *https://leetcode-cn.com/problems/top-k-frequent-elements/solution/qian-k-ge-gao-pin-yuan-su-by-leetcode-solution/
 *
 */
public class TopKElement {
    public static void main(String[] args) {
        int[] test ={1,1,1,2,2,3};
        int k=2;
        int[] topKUseBucklet = getTopKUseBucklet(test, k);
        Arrays.stream(topKUseBucklet).forEach(System.out::println);

    }

    //方法一 通过排序实现
    public static int[]  getTopKListUseSort(int[] nums,int k){
        //存放数字出现次数
        HashMap<Integer, Integer> frequentMap = new HashMap<>();
        for (int num : nums) {
            //出现过就加1
            frequentMap.getOrDefault(num,frequentMap.getOrDefault(num,0)+1);
        }
       //结合排序
        int[] ints = frequentMap.entrySet().stream().sorted((e1, e2) -> e2.getValue() - e1.getValue()).limit(k)
                .mapToInt(Map.Entry::getKey).toArray();
        return ints;

    }


    /** 思路是 将出现次数相同的数字放到相应的桶中
     * 然后遍历桶  取出前 k个数
     * 桶用数组实现 出现几次 对应哪个位置的桶
     * 第一种桶排序
     * @param nums 数组
     * @param k 返回top k 的个数
     * @return top k 的值
     */

    public static int[] getTopKUseBucklet(int[] nums,int k){
        List<Integer> res = new ArrayList();
        //存放数字出现次数
        HashMap<Integer, Integer> frequentMap = new HashMap<>();
        for (int num : nums) {
            //出现过就加1
            frequentMap.put(num,frequentMap.getOrDefault(num,0)+1);
        }
        //桶空出来一位  因为桶索引为0的位置不存在元素  至少出现1次
        List<Integer>[] buckletList=new List[nums.length+1];
        frequentMap.forEach((num,frequecy)->{
            //value 数值   frequecy出现的次数
            if(buckletList[frequecy]==null){
                buckletList[frequecy]=new ArrayList();
            }
            buckletList[frequecy].add(num);
        });
        // 倒序遍历数组获取出现顺序从大到小的排列
        for (int i = buckletList.length-1; i >=0&&res.size()<k; i--) {
            if(buckletList[i]==null){
                continue;
            }
            res.addAll(buckletList[i]);
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }










}
