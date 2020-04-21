package topic.lists;

/**
 * 删除链表中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        /**
         * 用后一个node的val覆盖node
         */
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
