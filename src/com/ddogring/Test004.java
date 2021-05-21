package com.ddogring;

/**
 * @ClassName Test004
 * @Author DdogRing
 * @Date 2021/5/11 0011 上午 8:45
 * @Description 难度中等  解码异或后的排列
 * @Version 1.0.0
 */
public class Test004 {
    public static void main(String[] args) {
        Test004 test004 = new Test004();
        int[] encoded = {6,5,4,6};
        test004.decode(encoded);
    }
    public int[] decode(int[] encoded) {
        int len=encoded.length;
        int[] perm=new int[len+1];

        int total_perm=0;//求perm数组的所有元素异或值
        for(int i=1;i<=len+1;i++){
            total_perm=total_perm^i;
            System.out.println("total_perm=" + total_perm);
        }

        int toatl_encoded=0;//求encoded数组中除了perm[0]以外的异或值
        for(int i=1;i<len;i+=2){
            toatl_encoded=toatl_encoded^encoded[i];
            System.out.println("toatl_encoded=" + toatl_encoded);
        }

        int start=total_perm^toatl_encoded;
        System.out.println("start=" + start);
        perm[0]=start;//和本月5号原题一模一样思路倒推原来的perm数组
        for(int i=1;i<len+1;i++){
            perm[i]=perm[i-1]^encoded[i-1];
            System.out.println("perm" + i + "=" + perm[i]);
        }
        return perm;
    }
}
