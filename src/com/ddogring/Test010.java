package com.ddogring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Test010
 * @Author DdogRing
 * @Date 2021/5/18 0018 上午 8:43
 * @Description 难度简单 牛客网 两数之和 字节跳动
 * @Version 1.0.0
 */
public class Test010 {
    public static void main(String[] args) {

        Test010 test010 = new Test010();
        int[] ints = {3,2,4};
        Arrays.stream(test010.twoSum(ints, 6)).forEach(System.out::println);
    }

    public int[] twoSum (int[] numbers, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            int key = target - numbers[i];
            if (map.containsKey(key)) {
                res[0] = map.get(key);
                res[1] = i + 1;
                break;
            }
            map.put(numbers[i], i + 1);
        }

        return res;
    }
}
