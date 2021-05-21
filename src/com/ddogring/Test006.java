package com.ddogring;


/**
 * @ClassName Test006
 * @Author DdogRing
 * @Date 2021/5/12 0012 上午 8:44
 * @Description 难度中等 子数组异或查询  思路利:用前缀异或(下方注释); 暴力也可(效率低下)
 * @Version 1.0.0
 */
public class Test006 {

    /*
        小明解答
        对于做过许多次前缀和问题的小明来说，这题他很快就有了思路，但是小明并没有趾高气昂，而是在为小伙伴小红解答问题。
        小红问道： 前缀和是什么？前缀和跟本题有什么联系？
        小明回答说： 前缀和的理解为对于 preSum[i]preSum[i] 表示其前 ii 项的和。举个例子：


        前缀和解释：
        假设我们有数组 arr: [1,2,3,4,5];
        前零项和的值为: 0 = 0
        前一项和的值为: 1 = 1
        前二项和的值为: 1+2 = 3
        前三项和的值为: 1+2+3 = 6
        前四项和的值为: 1+2+3+4 = 10
        前五项和的值为: 1+2+3+4+5 = 15

        因此它的前缀和数组为 preSum: [0, 1, 3, 6, 10, 15];

        假设现在我们想求 2 - 4 的和， 此时我们便不需要从 2 在加到 4；
        我们可以直接使用前四项的和值减去前一项和的值得到： 1+2+3+4 - 1 = 10 - 1 = 9
        因此前缀和可以使我们用O(1)的时间计算区间内的和.
        小红说： 这是前缀和呀，我们要求异或的值！
        小明回答说： 前缀和虽然是求和，但是为我们提供了很好的思路，但是这题我们需要明白一个异或的性质，我再给你举个例子：


        异或有自反性： 即任何数异或其本身等于 0；
        比如： a ⊕ a = 0;
        前缀异或的解释：对于 preXOR[i] 表示为前 i 项数的异或值
        假设我们有数组 arr: [1, 2, 3, 4, 7, 9];
        前零项的异或值为: 0 = 0
        前一项的异或值为: 1 = 1
        前二项的异或值为: 1 ⊕ 2 = 3
        前三项的异或值为: 1 ⊕ 2 ⊕ 3 = 0
        前四项的异或值为: 1 ⊕ 2 ⊕ 3 ⊕ 4 = 4
        前五项的异或值为: 1 ⊕ 2 ⊕ 3 ⊕ 4 ⊕ 7 = 3
        前六项的异或值为: 1 ⊕ 2 ⊕ 3 ⊕ 4 ⊕ 7 ⊕ 9 = 10

        因此它的前缀异或数组为 preXOR: [0, 1, 3, 0, 4, 3, 10];

        假设现在我们想求第 3 项到第 6 项的异或值， 此时我们不需要去暴力计算 "3 ⊕ 4 ⊕ 7 ⊕ 9"
        我们知道 (3 ⊕ 4 ⊕ 7 ⊕ 9) = (1 ⊕ 2) ⊕ (1 ⊕ 2 ⊕ 3 ⊕ 4 ⊕ 7 ⊕ 9)
        我们可以使用前缀异或的数组来计算第 3 项到第 6 项的异或值
        (1 ⊕ 2) 为前 2 项的异或值为 “3”
        (1 ⊕ 2 ⊕ 3 ⊕ 4 ⊕ 7 ⊕ 9) 为前 6 项异或值为 “10”
        因此第 3 项到第 6 项的异或值为：3 ⊕ 10 = 9
        所有对于前缀异或我们同样也可以用O(1)的时间计算区间内的异或值
    */
    public static void main(String[] args) {
        Test006 test006 = new Test006();
        int[] arr = {1,3,4,8};
        int[][] queries = {
                {0, 1},
                {1, 2},
                {0, 3},
                {3, 3}
        };
        int[] ints = test006.xorQueries(arr, queries);

        /*for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }*/
    }

    public int[] xorQueries(int[] arr, int[][] queries) {

        // 暴力思路
       /* int[] res = new int[queries.length];

        int is = 0;
        for (int i = 0; i < queries.length; i++) {

            int q0 = queries[i][0];
            int q1 = queries[i][1];

            int count = 0;
            for (int j = q0; j <= q1; j++) {
                count ^= arr[j];
            }
            res[is++] = count;
        }

        return res;*/

        // 前缀思路(属于暴力的优化)
        int[] arrs = new int[arr.length + 1];
        for(int i = 0; i < arr.length; i++) {
            arrs[i + 1] = arrs[i] ^ arr[i];
        }

        int[] res = new int[queries.length];
        for(int i = 0;i < queries.length; i++) {
            res[i] = arrs[queries[i][0]] ^ arrs[queries[i][1] + 1];
        }

        return res;
    }
}
