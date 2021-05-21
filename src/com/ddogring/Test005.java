package com.ddogring;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Test005
 * @Author DdogRing
 * @Date 2021/5/11 0011 上午 10:03
 * @Description 难度中等 两数之和 利用HashMap的key
 * @Version 1.0.0
 */
public class Test005 {

    public static void main(String[] args) {

        Test005 test005 = new Test005();
        int[] nums = {2,7,11,15};
        int target = 9;

        int[] ints = test005.twoSum(nums, target);

        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }

    public int[] twoSum(int[] nums, int target) {

        int[] ints = new int[2];
        Map<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                ints[0] = map.get(nums[i]);
                ints[1] = i;
                return ints;
            }
            map.put(target- nums[i], i);
        }

        return ints;
    }
}
