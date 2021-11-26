package com.sankdev.leetcode.addtwonumbers;

// Definition for singly-linked list.
class ListNode {

  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class Solution {

  public static void main(String[] args) {
    // Create lists
    ListNode f1 = new ListNode(9);
    ListNode f2 = new ListNode(9, f1);
    ListNode f3 = new ListNode(9, f2);
    ListNode f4 = new ListNode(9, f3);
    ListNode f5 = new ListNode(9, f4);
    ListNode f6 = new ListNode(9, f5);
    ListNode f7 = new ListNode(9, f6);

    ListNode s1 = new ListNode(9);
    ListNode s2 = new ListNode(9, s1);
    ListNode s3 = new ListNode(9, s2);
    ListNode s4 = new ListNode(9, s3);

//        ListNode f1 = new ListNode(2);
//        ListNode f2 = new ListNode(4, f1);
//        ListNode f3 = new ListNode(3, f2);
//
//        ListNode s1 = new ListNode(5);
//        ListNode s2 = new ListNode(6, s1);
//        ListNode s3 = new ListNode(4, s2);

//        ListNode f3 = new ListNode(0);
//
//        ListNode s3 = new ListNode(0);

    Solution s = new Solution();
    ListNode resultNode = s.addTwoNumbers(f7, s4);
    ListNode itr = resultNode;
    while (itr != null) {
      System.out.print(itr.val);
      itr = itr.next;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // Perform addition
    int a, b;
    ListNode i1 = l1;
    ListNode i2 = l2;
    ListNode resCurr = new ListNode();
    ListNode resNext;
    ListNode prevNode = new ListNode();
    // Remember the Head of the result list
    ListNode resultNode = resCurr;
    while (i1 != null || i2 != null) {
      if (i1 != null) {
        a = i1.val;
      } else {
        a = 0;
      }
      if (i2 != null) {
        b = i2.val;
      } else {
        b = 0;
      }
      resCurr.val = resCurr.val + a + b;

      if (resCurr.val >= 10) {
        resNext = new ListNode();
        resNext.val = 1;
        resCurr.val -= 10;
        prevNode = resCurr;
        resCurr.next = resNext;
        resCurr = resNext;
      } else {
        resNext = new ListNode();
        resNext.val = 0;
        prevNode = resCurr;
        resCurr.next = resNext;
        resCurr = resNext;
      }

      if (i1 != null) {
        i1 = i1.next;
      }
      if (i2 != null) {
        i2 = i2.next;
      }
    }

    if (prevNode.next.val == 0) {
      prevNode.next = null;
    }
    return resultNode;
  }

}
