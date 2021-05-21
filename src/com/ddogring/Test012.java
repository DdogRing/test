package com.ddogring;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @ClassName Test012
 * @Author DdogRing
 * @Date 2021/5/19 0019 上午 9:11
 * @Description 括号序列 简单 牛客网 腾讯
 * @Version 1.0.0
 */
public class Test012 {
    public static void main(String[] args) throws Exception {

        Test012 test012 = new Test012();

        System.out.println(test012.isValid("())"));
    }


    // 压栈弹栈思想 将字符串拆分成char数组迭代 判断括号压入相对应的另外半个括号 后进先出原则
    public boolean isValid (String str) {

        Stack<Character> stack = new Stack<>();
        for (char c:str.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.empty() || stack.pop() != c) return false;
        }
        System.out.println(stack);
        return stack.empty();
    }
}
