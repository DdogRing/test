package com.ddogring;

import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName Test001
 * @Author DdogRing
 * @Date 2021/5/6 0006 上午 8:42
 * @Description 难度中等  字符串无重复字符最长长度(滑块思路)    当遇见重复字符时 记录长度与原先记录的长度比较取最大值， 重新规划起始索引(结束索引无需顾虑，一直自增)
 * @Version 1.0.0
 */
public class Test001 {
    public static void main(String[] args) throws Exception {

        String s = "sdswbauvxp";

        Test001 test001 = new Test001();

        System.out.println(test001.lengthOfLongestSubstring2(s));

    }

    public int lengthOfLongestSubstring(String s) {

        // 起始索引
        int start = 0;
        // 结果长度
        int len = 0;

        Map<String, Integer> map = new HashMap<>(26);
        // end为结束时索引
        for (int end = 0; end < s.length(); end++) {

            // 每次截取一个字符串
            String substring = s.substring(end, end + 1);

            // 如果hashmap中包含此字符串
            if (map.containsKey(substring)) {
                // 将重新规划起始索引
                start = Math.max(map.get(substring), start);
            }

            // 利用hashmap相同key覆盖， 每次存结束时长度
            map.put(substring,end + 1);
            // 长度为结束时长度减去起始索引
            len = Math.max(end + 1 - start, len);
        }
        return len;
    }

    public int lengthOfLongestSubstring2(String s) {

        // 起始索引
        int start = 0;
        // 结果长度
        int len = 0;

        int[] ins = new int[128];

        for (int end = 0; end < s.length(); end++) {

            int c = s.charAt(end);
            start = Math.max(start, ins[c]);
            ins[c] = end + 1;
            len = Math.max(end - start + 1, len);
        }
        return len;
    }
}
