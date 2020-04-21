package topic.lists;

/**
 * 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class HasCycle {

    //快慢指针解决  操场一快一慢跑步 终会相遇
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
