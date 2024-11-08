package cf.carefulhuo.leetcode.linkedlist;

import java.util.Stack;

/**
 * 删除链表的倒数第 N 个节点
 */
public class removeNthFromEnd {

    private static ListNode head;

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
        add(node1);
        add(node2);
//        add(node3);
//        add(node4);
//        add(node5);
        printAll();
        head = removeNthFromEnd(head, 2);
        printAll();
    }

    /**
     * 通过堆栈的方式，实现删除倒数第 N 个元素
     * 还有其他的方式，比如双指针，
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Stack<ListNode> stack = new Stack<>();
        ListNode p = dummy;

        while (p != null) {
            stack.push(p);
            p = p.next;
        }

        for (int i = 0; i < n; ++i) {
            stack.pop();
        }

        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return dummy.next;
    }

    public static void add(ListNode node) {
        if (head == null) {
            head = node;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }


    private static void printAll() {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }


    private static class ListNode {
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
