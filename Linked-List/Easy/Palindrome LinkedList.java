Problem statement :

Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false


Solution :
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        
        while(temp != null){
            stack.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            if(temp.val != stack.peek()) return false;
            stack.pop();
            temp = temp.next;
        }
        return true;
    }
}
