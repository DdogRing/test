package com.ddogring;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Test009
 * @Author DdogRing
 * @Date 2021/5/15 0015 上午 9:10
 * @Description 罗马数字转整数 难度简单 思路与Test007相反
 * @Version 1.0.0
 */
public class Test009 {

    public static void main(String[] args) {
        String s = "LVIII";

        Test009 test009 = new Test009();
        System.out.println(test009.romanToInt1(s));
        System.out.println(test009.romanToInt2(s));
    }

    /**
     * 此种做法时间效率比较低 思路 HashMap key的唯一性
     * @author DdogRing
     * @date 2021/5/15 0015 上午 10:04
     * @param s
     * @return int
     **/
    public int romanToInt1(String s) {

        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        Map<String, Integer> map = new HashMap<>(13);
        map.put("M", 0);
        map.put("CM", 1);
        map.put("D", 2);
        map.put("CD", 3);
        map.put("C", 4);
        map.put("XC", 5);
        map.put("L", 6);
        map.put("XL", 7);
        map.put("X", 8);
        map.put("IX", 9);
        map.put("V", 10);
        map.put("IV", 11);
        map.put("I", 12);

        s += " ";
        int start = 0;
        int num = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (map.containsKey(s.substring(start, i + 2))) {
                num += nums[map.get(s.substring(start, i + 2))];
                start += 2;
                i++;
            } else {
                num += nums[map.get(s.substring(start, i + 1))];
                start += 1;
            }
        }

        return num;
    }


    /**
     * 此方法效率及高 原理 比较前置指针与当前指针的值 若前置指针 >= 当前指针则做加法 若小于当前指针 则做减法 最后一位不考虑 直接做加法
     * @author DdogRing
     * @date 2021/5/15 0015 上午 10:40
     * @param s
     * @return int
     **/
    /**
     * 例如:
     *  X  X  V  I  I 27
     *  10 10 5  1  1 27
     *
     *  X  X  I  V  I 25
     *  10 10 -1  5 1 25
     */
    public int romanToInt2(String s) {

        int preNum = getValue(s.charAt(0));
        int sum = 0;
        for (int i = 1; i < s.length(); i++) {
            int value = getValue(s.charAt(i));
            if (value > preNum) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = value;
        }
        sum += preNum;
        return sum;
    }

    public int getValue(char ch) {

        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}
