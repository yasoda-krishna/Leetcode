## Problem: Rotate Image

### Problem Statement
You are given an `n x n` 2D matrix representing an image. Rotate the image by 90 degrees clockwise.

### Solution Explanation

The solution to rotate the matrix by 90 degrees clockwise involves two main steps: transposing the matrix and then reversing each row. Here's a detailed breakdown of the process:

1. **Transpose the Matrix**:
   Transposing the matrix involves converting all rows to columns and vice versa. This is done by swapping the elements at position `[i][j]` with the elements at position `[j][i]`. We only need to iterate through the upper triangle of the matrix (including the diagonal) to avoid swapping elements twice.

   ```java
   // Transpose the matrix
   for (int i = 0; i < n; i++) {
       for (int j = i; j < n; j++) {
           int temp = matrix[i][j];
           matrix[i][j] = matrix[j][i];
           matrix[j][i] = temp;
       }
   }
    ```
For example, given the matrix:
```
1 2 3
4 5 6
7 8 9
```
After transposition, it becomes:
```
1 4 7
2 5 8
3 6 9
```

2. **Reverse Each Row**:
   After transposing the matrix, each row is reversed. This will effectively rotate the matrix by 90 degrees clockwise. We swap the elements at the start and end of each row, moving towards the center.

   ```java
    // Reverse each row
   for (int i = 0; i < n; i++) {
    for (int j = 0; j < n / 2; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][n - j - 1];
        matrix[i][n - j - 1] = temp;
    }
    }
   ```
For example, after reversing each row, the matrix becomes:
```
7 4 1
8 5 2
9 6 3
```
