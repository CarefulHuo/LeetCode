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
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        add(node1);
        add(node2);
        add(node3);
        add(node4);
        add(node5);
        printAll();
        head = removeNthFromEnd3(head, 2);
        printAll();
    }

    /**
     * 通过堆栈的方式，实现删除倒数第 N 个元素
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

    /**
     * 通过双指针和添加头结点的方式，实现删除倒数第 N 个元素
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;

        // 前进第一个指针，使第一个指针和第二个指针之间的间距相隔 n 个节点
        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        // 移动 second 和 first，直到 first 指向链表尾部
        // 此时 second 节点就是需要被删除的节点的上一个节点
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;
    }

    public static ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode first = head;
        int i = 1;
        while (first.next != null && i < n) {
            first = first.next;
            i++;
        }

        if (first == null) return head;

        ListNode second = head;
        ListNode prev = null;
        while (first.next != null) {
            first = first.next;
            prev = second;
            second = second.next;
        }

        if (prev == null) {
            head = head.next;
        } else {
            prev.next = prev.next.next;
        }
        return head;
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
