package algorithm.cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class LRU {
    /** LRU Least Recently used 最近最少使用
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    /**
     * 示例输入 [[1,1,1],[1,2,2],[1,3,2],[2,1],[1,4,4],[2,2]],3
     * 输出  [1,-1]
     链接：https://www.nowcoder.com/questionTerminal/e3769a5f49894d49b871c09cadd13a61
     来源：牛客网

     第一次操作后：最常使用的记录为("1", 1)
     第二次操作后：最常使用的记录为("2", 2)，("1", 1)变为最不常用的
     第三次操作后：最常使用的记录为("3", 2)，("1", 1)还是最不常用的
     第四次操作后：最常用的记录为("1", 1)，("2", 2)变为最不常用的
     第五次操作后：大小超过了3，所以移除此时最不常使用的记录("2", 2)，加入记录("4", 4)，并且为最常使用的记录，然后("3", 2)变为最不常使用的记录

     */

    public static int[] lRU (int[][] operators, int k) {
        // write code here
        //分解 使用linkedHashMap
        //如果操作为1 则取出key ,value 删除最初保存的值同时put进去最新的值
        //如果操作为2  如果没有返回-1  否则从map中get key值  并且删除之前在map里位置，使用put放入这回key -value
        LinkedHashMap<Integer, Integer> lruMap = new LinkedHashMap<Integer, Integer>();
        List<Integer> retList=new ArrayList<Integer>();
        for (int[] operator : operators) {
            int optType = operator[0]; //1 set 2 get
            int key=operator[1];
            if(optType==1){
                if(lruMap.containsKey(key)){
                    lruMap.remove(key);
                }else{
                    if(lruMap.size()==k){
                        lruMap.remove(lruMap.keySet().toArray()[0]);
                    }
                }
                lruMap.put(key,operator[2]);
            }else if(optType==2){
                if(lruMap.containsKey(key)){
                    int val=lruMap.remove(key);
                    lruMap.put(key,val);
                    retList.add(lruMap.get(key));
                }else{
                    retList.add(-1);
                }
            }

        }
        int[] ints = retList.stream().filter(i -> i != null).mapToInt(Integer::intValue).toArray();
        Arrays.stream(ints).forEach(System.out::println);
        return ints;


    }

    public static void main(String[] args) {
        int[][] test={{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}};
        lRU(test,3);
    }




}













