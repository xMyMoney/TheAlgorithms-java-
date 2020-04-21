package topic.lists;

/**
 * 反转链表
 * 输入： 1 2 3 4 5 null
 * 输出： 5 4 3 2 1 null
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode newHead = null;
        while (head != null){
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }
}
