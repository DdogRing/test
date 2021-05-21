package com.ddogring;

/**
 * @ClassName Test007
 * @Author DdogRing
 * @Date 2021/5/13 0013 上午 9:18
 * @Description 难度中等 整数转罗马字符(思路 贪心算法) 列举可能出现的几种情况的罗马字符与阿拉伯数字对应索引
 * @Version 1.0.0
 */
public class Test007 {
    public static void main(String[] args) {
        Test007 test007 = new Test007();

        System.out.println(test007.intToRoman(20));
    }

    public String intToRoman(int num) {

        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < nums.length; i++) {
            while (num >= nums[i]) {
                sb.append(romans[i]);
                num -= nums[i];
            }
        }

        return sb.toString();
    }
}
