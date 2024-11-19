package cf.carefulhuo.leetcode.sort;

import java.util.List;

/**
 * 147. 对链表进行插入排序
 */
public class InsertionSortList {
    public static void main(String[] args) {
        ListNode head = null;
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        head = add(l1, head);
        head = add(l2, head);
        head = add(l3, head);
        print(head);
        print(insertionSortList(head));
    }

    public static ListNode insertionSortList(ListNode head) {
        ListNode tail = null;
        ListNode temp = head;
        while (temp != null) {
            if (tail == null) {
                tail = new ListNode(temp.val, null);
            } else {
                ListNode p = tail;
                ListNode q = null;
                if (p.val <= temp.val) {
                    // 尾插法
                    temp.next = p.next;
                    p.next = temp;
                } else {
                    if (q == null){
                        temp.next = p;
                        tail = temp;
                    }else{
                        ListNode n  = q.next;;
                        q.next = temp;
                        temp.next = n;
                    }

                }
            }
            temp = temp.next;
        }
        head = tail;
        return head;
    }

    public static ListNode add(ListNode node, ListNode head) {
        if (head == null) {
            head = node;
        } else {
            // 头插法
            node.next = head;
            head = node;
        }
        return head;
    }

    public static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }


    public static class ListNode {
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

}
