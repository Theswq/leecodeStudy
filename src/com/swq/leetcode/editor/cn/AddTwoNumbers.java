//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 6004 👎 0


package com.swq.leetcode.editor.cn;

import java.util.List;

public class AddTwoNumbers{
  public static void main(String[] args) {
      ListNode a1 = new ListNode(2);
      ListNode a2 = new ListNode(4);
      ListNode a3 = new ListNode(3);
      a1.next = a2;
      a2.next = a3;

      ListNode b1 = new ListNode(5);
      ListNode b2 = new ListNode(6);
      ListNode b3 = new ListNode(4);
      b1.next = b2;
      b2.next = b3;
      ListNode resultNode = new AddTwoNumbers().new Solution().addTwoNumbers(a1, b1);

    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = (l1 != null) ? l1.value : 0;
            int n2 = (l2 != null) ? l2.value : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                //初始化头节点尾节点
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            //记录进位
            carry = sum / 10;
            if (l1 != null) {
                //下一个节点提到前面
                l1 = l1.next;
            }
            if (l2 != null) {
                //下一个节点提到前面
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
static class ListNode {

    private int value;
    private ListNode next;

    public ListNode() {
    }

    public ListNode(int value) {
        this.value = value;
    }
}
}
