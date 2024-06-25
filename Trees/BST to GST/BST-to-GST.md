# Binary Search Tree to Greater Sum Tree

## Problem Statement
Given the root of a Binary Search Tree (BST), convert it to a Greater Sum Tree (GST) where every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.

## Example

Consider the BST:
    
    ```
            4
        / \
        1   6
        / \   \
        0   2   7
            \   \
            3   8
    ```

The corresponding GST is:
    
    ```
            30
        / \
        36  21
        / \   \
        36 35  26
            \   \
            33  8
    ```


## Constraints

- The number of nodes in the tree is in the range `[1, 100]`.
- `0 <= Node.val <= 100`.
- All the values in the tree are unique.

## Solution Explanation

The problem can be solved using a reverse in-order traversal of the tree. By traversing the tree in reverse in-order (right -> node -> left), we can keep a running sum of all the nodes we've visited so far and update each node's value accordingly.

1. **Global Variable for Sum**:
    - We maintain a global variable `sum` to keep track of the cumulative sum of node values during the traversal.

   ```java
   int sum = 0;
2. **Main Method `bstToGst`**:

   - This method initializes the process by calling the helper method updateTree with the root of the BST.
   - It then returns the modified tree.
   
   ```java
    public TreeNode bstToGst(TreeNode root) {
         updateTree(root);
         return root;
    }
    ```
3. **Helper Method `updateTree`**:
    
   - This method performs the reverse in-order traversal of the tree.
   - It recursively updates the node values by adding the sum of all greater nodes to the current node value.
   - It then updates the sum variable with the current node value.
   
   ```java
    private void updateTree(TreeNode node) {
        if (node == null) {
            return;
        }
        updateTree(node.right);
        sum += node.val;
        node.val = sum;
        updateTree(node.left);
    }
    ```
   
4. **Time Complexity**:
    - The time complexity of this approach is `O(n)`, where `n` is the number of nodes in the tree.
    - We visit each node once during the reverse in-order traversal.

5. **Space Complexity**:
    - The space complexity is `O(h)`, where `h` is the height of the tree.
    - The space is used for the recursive call stack during the traversal.

