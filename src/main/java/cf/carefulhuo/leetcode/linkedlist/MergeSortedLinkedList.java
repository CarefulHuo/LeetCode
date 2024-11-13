package cf.carefulhuo.leetcode.linkedlist;

/**
 * 合并两个有序链表
 */
public class MergeSortedLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(5);
        add(l2, l1);
        add(l3, l1);
        print(l1);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        add(l5, l4);
        add(l6, l4);
        print(l4);
        print(mergeSortedLists(l1, l4));
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeSortedLists(ListNode l1, ListNode l2) {
        // 添加头结点，降低链表插入节点的难度
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            // 保证 p 不断指向最新的节点
            p = p.next;
        }
        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return dummyHead.next;
    }


    private static ListNode add(ListNode node, ListNode head) {
        if (head == null) {
            head = node;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }
        return head;
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
