package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lukCy on 2017/4/25.
 * 题目目的是判定给定数组nums里有长度大于2的连续子序列其和等于目标数k的倍数，
 * 网上的方法绝了：将数组一直相加%k求mod，判断num[0]+num[1]+...+num[precheck] + b*k = num[0]+num[1]+num[2]+...+num[i]中
 * 当数组下标为precheck和i的连续数组和对k的余数相等的时候，说明，num[precheck]+num[precheck+1]+...+num[i] = b*k，
 * 即存在连续数组的和是k的倍数，需要注意：1、该数组长度大于2；2、k等于0的情况，当k=0时，非负整数的数组和不可能是0
 * 巧妙的在于创建一个hashmap，key为每次的余数，value为该余数相应的下标，一个余数可以对应对个下标，所以能解决这个问题。
 */
public class _523CheckSubarraySum {
    public boolean checkSubarraySum(int[] nums,int k){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        map.put(0,-1);
        int sum = 0;
        for (int i=0;i<nums.length;i++){
            sum += nums[i];
            if (k != 0)
                sum = sum % k;
            Integer precheck = map.get(sum);
            if (precheck != null){
                if (i - precheck > 1)
                    return true;
            }
            else map.put(sum,i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {23,2,6,4,7};
        int k = 7;
        System.out.println(new _523CheckSubarraySum().checkSubarraySum(nums,k));
    }
}
