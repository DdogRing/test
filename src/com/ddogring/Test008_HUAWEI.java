package com.ddogring;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @ClassName Test008_HUAWEI
 * @Author DdogRing
 * @Date 2021/5/14 0014 上午 9:14
 * @Description 牛客网 华为机试-简单密码 难度中等 需要对ASCII码有一定了解 不了解可用字符代替
 * @Version 1.0.0
 */
public class Test008_HUAWEI {

    /**
     *  题目描述
     *
     * 密码是我们生活中非常重要的东东，我们的那么一点不能说的秘密就全靠它了。哇哈哈. 接下来渊子要在密码之上再加一套密码，虽然简单但也安全。
     * 假设渊子原来一个BBS上的密码为zvbo9441987,为了方便记忆，他通过一种算法把这个密码变换成YUANzhi1987，这个密码是他的名字和出生年份，
     * 怎么忘都忘不了，而且可以明目张胆地放在显眼的地方而不被别人知道真正的密码。
     * 他是这么变换的，大家都知道手机上的字母： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0,
     * 就这么简单，渊子把密码中出现的小写字母都变成对应的数字，数字和其他的符号都不做变换，
     *
     * 声明：密码中没有空格，而密码中出现的大写字母则变成小写之后往后移一位，如：X，先变成小写，再往后移一位，不就是y了嘛，简单吧。记住，z往后移是a哦。
     *
     */

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] chars = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 大写情况
            if (c >= 65 && c < 90){
                c += 33;
                chars[i] = c;
                // 大写Z情况
            } else if (c == 90) {
                c = 97;
                chars[i] = c;
                // 小写a-r情况
            } else if (c >= 97 && c <= 114) {
                c = (char)((c - 97) / 3 + 50);
                chars[i] = c;
                // 小写s-y情况
            } else if (c >= 115 && c < 122) {
                c = (char)((c - 97 - 1) / 3 + 50);
                chars[i] = c;
                // 小写z情况
            } else if (c == 122) {
                chars[i] = 57;
                // 请他情况
            } else {
                chars[i] = c;
            }
        }

        System.out.println(String.valueOf(chars));

    }
}
