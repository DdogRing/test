package com.ddogring;

/**
 * @ClassName Test003
 * @Author DdogRing
 * @Date 2021/5/10 0010 上午 9:29
 * @Description 难度中等 两数相加（利用预先指针指向当前指针 防止当前指针丢失）
 * @Version 1.0.0
 */
public class Test003 {

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建预先节点 防止当前节点位置丢失
        ListNode pre = new ListNode(0);
        // 将当前预先节点的内存地址赋值给当前节点
        ListNode cur = pre;
        // 进位
        int carry = 0;

        while(l1 != null || l2 != null) {

            // 计算出两数之和
            int num = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;

            // num >= 10 情况做除法 获得进位1
            carry = num / 10;
            // num >= 10 情况做取余 获取余数
            num %= 10;

            // 当前节点的下一个节点 存放num
            cur.next = new ListNode(num);

            // 让当前节点为下一个节点
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }

        return pre.next;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}