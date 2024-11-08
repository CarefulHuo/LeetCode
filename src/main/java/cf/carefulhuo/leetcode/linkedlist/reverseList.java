package cf.carefulhuo.leetcode.linkedlist;

/**
 * 反转链表
 */
public class reverseList {

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
        head = reverseListV2(head);
        printAll();
    }


    /**
     * 反转链表很直白，很low的写法
     *
     * @param head
     * @return
     */
    private static ListNode reverseList(ListNode head) {
        ListNode p = head;
        ListNode r = null;
        while (p != null) {
            if (r == null) {
                r = p;
                p = p.next;
                r.next = null;
                head = r;
            } else {
                ListNode temp = p;
                p = p.next;
                temp.next = head;
                head = temp;
            }
        }
        return head;
    }

    /**
     * 反转链表写法2 ，很赞的写法
     * 通过改变节点的指向，利用头插法完成链表转换
     * @param head
     * @return
     */
    private static ListNode reverseListV2(ListNode head) {
        ListNode p = head;
        ListNode r = null;
        while (p != null) {
            ListNode tmp = p.next;  //暂存下一个节点
            p.next = r;             // 改变当前节点的 next 指向
            r = p;                  // 改变 r 的指向
            p = tmp;                // 移动 p 指针，进行循环
        }
        return r;
    }

    private static void add(ListNode node) {
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
