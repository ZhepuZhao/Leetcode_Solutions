package leetcode;

public class PalindromeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ListNode head = new ListNode(1);
//		head.next = new ListNode(2);
//		head.next.next = new ListNode(2);
//		isPalindrome(head);
		String s = "12345";
		System.out.println(s.substring(0,0));
	}
	
    public static boolean isPalindrome(ListNode head) {
//        ListNode l = copy(head);
//        ListNode current = head;
//        ListNode help = l;
//        ListNode previous = null;
//        
//        while (current != null){
//            current = head.next;
//            head.next = previous;
//            previous = head;
//            head = current;
//        }
//               
//        current = previous;
//        while(current != null){
//            if (current.val != help.val){
//                return false;
//            }
//            current = current.next;
//            help = help.next;
//        }
//        return true;
        // use less space
        if (head == null) return true;
        ListNode current = head;
        ListNode reversed = null;
        int count = 0;
        while(current != null){
            current = current.next;
            count++;
        }
        int num = 1;
        current = head;
        while (num <= count/2){
            current = current.next;
            num++;
        }
        reversed = current;
        if (count % 2 == 0){ // even number of nodes in the list
            reversed = reverse(reversed);
        } else{ // odd number of nodes in the list
            reversed = reverse(reversed.next);                       
        }
        current = head;
        ListNode help = reversed;
        while(help != null){
            if (current.val != help.val){
                return false;
            }
            current = current.next;
            help = help.next;
        }
        return true;        
        
    }
    public static ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode previous = null;
        while (current != null){
            current = head.next;
            head.next = previous;
            previous = head;
            head = current;
        }        
        return previous;
    }
    public static ListNode copy(ListNode head){
        ListNode current = head.next;
        ListNode l = new ListNode(head.val);
        ListNode help = l;
        while (current != null){
            ListNode a = new ListNode(current.val);
            current = current.next;            
            help.next = a;
            help = help.next;
        }
        return l;
    }

}
