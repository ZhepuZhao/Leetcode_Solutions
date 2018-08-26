package leetcode;

public class ReverseLinkedNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode current = head;
		for (int i = 2; i < 6; i++) {
			current.next = new ListNode(i);			
			current = current.next;			
		}
		reverseList(head);
	}

	public static ListNode reverseList(ListNode head) {
//		ListNode result = head;
//		ListNode current = head;
//		ListNode previous = head;
//		while (head != null) {
//			while (current.next != null) {
//				previous = current;
//				current = current.next;
//			}
//			current.next = previous;
//			previous.next = null;
//			result = current;
//			current = head;
//			previous = head;
//		}
//
//		return result;
        if (head.next == null) return head;
        ListNode current = head;
        head = head.next;
        reverseList(head).next = current;
        current.next = null;
        return reverseList(head);		
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
