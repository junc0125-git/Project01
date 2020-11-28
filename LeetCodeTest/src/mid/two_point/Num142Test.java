package mid.two_point;

/**
 * @author cj
 * @create 2020-11-19 13:06
 * <p>
 * 142. 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * <p>
 * 说明：不允许修改给定的链表。
 * 进阶：
 * 你是否可以使用 O(1) 空间解决此题？
 * <p>
 * <p>
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 * <p>
 * 提示：
 * 链表中节点的数目范围在范围 [0, 104] 内
 * -105 <= Node.val <= 105
 * pos 的值为 -1 或者链表中的一个有效索引
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Num142Test {
    public ListNode detectCycle(ListNode head) {
        //快慢指针  如果快指针追上慢指针则有环，否则则没环
        ListNode q, s;
        q = head;
        s = head;
        int hl = 0;//环的长度
        if (head == null || head.next == null)
            return null;
        while (q.next != null && s.next != null) {
            q = q.next;
            if (q.next != null)
                q = q.next;
            else
                break;
            s = s.next;
            if (q == s)
                break;
        }
        //无环
        if (q.next == null)
            return null;
        //第二次相遇计算环长度
        while (q.next != null && s.next != null) {
            q = q.next;
            if (q.next != null)
                q = q.next;
            else
                break;
            s = s.next;
            hl++;
            if (q == s)
                break;
        }
        //快慢指针同时归0
        q = head;
        s = head;
        //快指针先走一个环的长度
        for (int i = 0; i < hl; i++) {
            q = q.next;
        }
        //快慢指针同时一步一步的走
        while (q.next != null && s.next != null) {
            //先看相遇点是否是入口
            if (q == s)
                break;
            q = q.next;
            s = s.next;
        }
        return q;
    }
}