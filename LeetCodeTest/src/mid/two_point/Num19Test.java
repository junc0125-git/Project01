package mid.two_point;

/**
 * @author cj
 * @create 2020-11-19 8:59
 * <p>
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * <p>
 * 说明：
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 */
public class Num19Test {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //两个指针 l  r
        ListNode l, r;
        l = head;
        r = head;
        //n:0
        if (n == 0)
            return head;

        //只有一个节点
        if (head.next == null && n == 1) {
            return null;
        }

        //两个指针间相差n
        //r前移n格
        for (int i = 0; i < n; i++) {
            r = r.next;
        }

        //删除头结点
        if (r == null) {
            l = l.next;
            return l;
        }

        //r -> next != null    l=l->next;  r=r->next
        while (r.next != null) {
            l = l.next;
            r = r.next;
        }
        //else : l->next=l->next->next;
        l.next = l.next.next;
        return head;

    }
}

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