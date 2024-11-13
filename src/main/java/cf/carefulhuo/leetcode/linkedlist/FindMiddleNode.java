package cf.carefulhuo.leetcode.linkedlist;

public class FindMiddleNode {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
//        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(4);
        add(l2, l1);
//        add(l3, l1);
        add(l4, l1);
        add(l5, l1);
        print(l1);
        System.out.println(middleNode2(l1));

    }

    /**
     * 寻找链表的中间节点，奇数为中间节点，偶数为中间两个节点的第二个节点
     *
     * @param head
     * @return
     */
    public static int middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.val;
    }

    /**
     * 寻找链表的中间节点，奇数为中间节点，偶数为中间两个节点的第一个节点
     *
     * @param head
     * @return
     */
    public static int middleNode2(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.val;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
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
