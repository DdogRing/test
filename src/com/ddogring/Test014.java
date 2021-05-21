package com.ddogring;

/**
 * @ClassName Test014
 * @Author DdogRing
 * @Date 2021/5/20 0020 上午 9:28
 * @Description 斐波那契数列 (兔子繁殖问题) 牛客网 TP-LINK 入门
 * @Version 1.0.0
 */
public class Test014 {
    public static void main(String[] args) {
        Test014 test014 = new Test014();

        System.out.println(test014.Fibonacci1(4));
    }

    // 递归
    public int Fibonacci(int n) {

        if (n <= 1) {
            return n;
        }

        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    // 递推算法 类似猴子爬山 经典以空间换时间
    public int Fibonacci1(int n) {

        int[] k = new int[40];

        k[0] = 0;
        k[1] = 1;
        k[2] = 1;
        k[3] = 2;

        for (int i = 4; i <= n; i++) {
            k[i] = k[i - 1] + k[i - 2];
        }
        return k[n];
    }

}
