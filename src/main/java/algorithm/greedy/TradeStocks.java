package algorithm.greedy;

import java.util.HashMap;

/**
 * 买卖股票的最佳时机
 * 1 给定一个数组，它的第i元素是一支给定固定第i天的价格
 *  如果你最多只允许完成一笔交易  即买入和卖出股票一次
 * 求最大利润
 *
 *   限制  先买入 后卖出
 *
 *   示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 *
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 *
 *
 *
 */
public class TradeStocks {

    public static void main(String[] args) {
        int[] k={7, 1, 5, 3, 6, 4};
    }

    //我的思路就是 数组 j->k  买入b  卖出 s    那么买入b之后到k之间就是找一个差值最大  min 最初存放0  找到比它大的 替换
    //一次遍历  用一个map存放key买入值   value存放计算的利润
    public static void  gainProfit(int[] stocks){
        HashMap<Integer, Integer> gainMap = new HashMap<>();
        for (int i = 0; i < stocks.length; i++) {
            int price = stocks[i];
            Integer origPrice = gainMap.getOrDefault(price, 0);
        }
    }
}
