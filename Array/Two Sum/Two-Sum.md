## Problem: Two Sum

### Problem Statement
Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.

### Solution Explanation

The solution uses a brute force approach to find the indices of the two numbers in the array that add up to the target. Here's a detailed breakdown of the process:

1. **Initialize Variables**:
   - `len`: Stores the length of the input array `nums`.
   - `arr`: An array of size 2 to store the indices of the two numbers that add up to the target.

      ```java
      int len = nums.length;
      int[] arr = new int[2];
     ```
2. **Nested Loop to Check Pairs**:

   - The outer loop runs from the start of the array to the second last element.
   - The inner loop runs from the element next to the current element in the outer loop to the end of the array.
   - For each pair of indices (i, j), it checks if the sum of the elements at these indices equals the target.
   
        ```java
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                    break;
                }
            }
        }
        ```
3. **Return the Result**:
    - After finding the indices of the two numbers that add up to the target, return the array `arr`.
    
         ```java
          return arr;
      ```