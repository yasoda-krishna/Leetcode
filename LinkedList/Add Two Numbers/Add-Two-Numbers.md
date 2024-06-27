# Add Two Numbers

## Problem Statement

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

## Examples

**Example 1:**

Input: `l1 = [2,4,3]`, `l2 = [5,6,4]`  
Output: `[7,0,8]`  
Explanation: `342 + 465 = 807`.

**Example 2:**

Input: `l1 = [0]`, `l2 = [0]`  
Output: `[0]`

**Example 3:**

Input: `l1 = [9,9,9,9,9,9,9]`, `l2 = [9,9,9,9]`  
Output: `[8,9,9,9,0,0,0,1]`

## Constraints

- The number of nodes in each linked list is in the range `[1, 100]`.
- `0 <= Node.val <= 9`
- It is guaranteed that the list represents a number that does not have leading zeros.

## Solution Explanation

The problem can be solved using a single traversal of both linked lists. We maintain a carry that we add to the sum at each position. The sum at each position is calculated by adding the values of the corresponding nodes of both lists (if they exist) and the carry from the previous position. The result at each position is stored in a new linked list.

### Steps to Solve the Problem

1. **Initialization**:
    - We initialize `head` and `temp` to `null`. `head` will be the head of the resultant linked list.
    - We initialize `carry` to 0.

   ```java
   ListNode head = null;
   ListNode temp = null;
   int carry = 0;
   ```
2.	**Loop Through Lists**:
      - We loop through both lists until both are exhausted.
      - At each iteration, we add the values of the nodes of both lists (if they exist) and the carry from the previous iteration.
      - We create a new node with the value of sum % 10 and update the carry to sum / 10.
    
    ```java
    while (l1 != null || l2 != null) {
    int sum = carry;
    if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
    }
    if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
    }
    ListNode node = new ListNode(sum % 10);
    carry = sum / 10;
    ```
3.	**Handle the Head of the Resultant List**:
      -	If temp is null, it means this is the first node of the resultant list. We initialize both temp and head to this node.
      -	Otherwise, we set temp.next to the new node and move temp to temp.next.

    ```java
       if (temp == null) {
        temp = head = node;
    } else {
        temp.next = node;
        temp = temp.next;
    }
    ```
4.	**Handle Remaining Carry**:
      -	After the loop, if there is any carry left, we create a new node with this carry and add it to the end of the list.

    ```java
    if (carry > 0) {
        temp.next = new ListNode(carry);
    }
    ```
**Notes**

	-	The solution has a time complexity of O(max(m, n)), where m and n are the lengths of the two linked lists, as each list is traversed once.
	-	The space complexity is O(max(m, n)) due to the creation of the new linked list to store the result.