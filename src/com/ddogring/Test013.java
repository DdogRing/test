package com.ddogring;

import java.util.*;

/**
 * @ClassName Test013
 * @Author DdogRing
 * @Date 2021/5/20 0020 上午 8:55
 * @Description 前K个高频单词 难度中等 主要考察了HashMap 以及其中API的使用
 * @Version 1.0.0
 */
public class Test013 {
    public static void main(String[] args) {
        Test013 test013 = new Test013();

        String[] words =  {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(test013.topKFrequent(words, 4));
    }

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            // getOrDefault(key, defaultValue) 此方法通过key获取value，如果key不存在，可通过defaultValue给一个默认值
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> list = new ArrayList<>();

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            list.add(entry.getKey());
        }

        Collections.sort(list, (a,b) -> map.get(a) == map.get(b) ? a.compareTo(b) : map.get(b) - map.get(a));

        return list.subList(0,k);
    }
}
