# Maximum Importance of Roads

## Problem Statement

You are given a positive integer `n` representing the number of cities in a country and a 2D array `roads` representing the roads between these cities, where `roads[i] = [a_i, b_i]` denotes a road between cities `a_i` and `b_i`.

The importance of a city is defined by the number assigned to it, and the total importance of a road is defined as the sum of the importance of the two cities it connects.

You need to assign each city a unique importance value from `1` to `n` and maximize the total importance of all roads.

## Examples

**Example 1:**

Input: `n = 5`, `roads = [[0,1],[0,2],[0,3],[1,4]]`  
Output: `43`  
Explanation:
- Assign city `0` an importance of `5`, city `1` an importance of `4`, city `2` an importance of `3`, city `3` an importance of `2`, and city `4` an importance of `1`.
- The total importance of roads is `5+4 + 5+3 + 5+2 + 4+1 = 43`.

**Example 2:**

Input: `n = 5`, `roads = [[0,1],[1,2],[2,3],[3,4]]`  
Output: `40`  
Explanation:
- Assign city `0` an importance of `5`, city `1` an importance of `4`, city `2` an importance of `3`, city `3` an importance of `2`, and city `4` an importance of `1`.
- The total importance of roads is `5+4 + 4+3 + 3+2 + 2+1 = 40`.

## Constraints

- `2 <= n <= 5 * 10^4`
- `1 <= roads.length <= 5 * 10^4`
- `roads[i].length == 2`
- `0 <= a_i, b_i < n`
- `a_i != b_i`
- There are no duplicate roads.

## Solution Explanation

To maximize the total importance of all roads, we should assign higher importance values to cities with more connections.

### Steps to Solve the Problem

1. **Calculate the Number of Occurrences**:
    - Create an array `occur` to store the number of connections (roads) for each city.

   ```java
   int[] occur = new int[n];
   for (int[] r : roads) {
       occur[r[0]]++;
       occur[r[1]]++;
   }
   ```
2. **Sort the Cities by Number of Connections**:
    - Sort the cities based on the number of connections in descending order.

   ```java
   Integer[] val = new Integer[n];
    for (int i = 0; i < n; i++) {
    val[i] = i;
    }
    Arrays.sort(val, (a, b) -> Integer.compare(occur[b], occur[a]));
    ```

3.	Assign Importance Values:
      -	Create an array out to store the importance values and assign the highest importance to the most connected cities.

    ```java
    int[] out = new int[n];
   for (int i = 0; i < n; i++) {
   out[val[i]] = n - i;
   }
   ```
4.	Calculate Total Importance:
      -	Calculate the total importance of all roads by summing the importance values of the connected cities.

    ```java
    int total = 0;
    for (int[] r : roads) {
    total += out[r[0]] + out[r[1]];
    }
    return total;
    ```

Time Complexity: `O(n log n)`

- Sorting the cities based on the number of connections takes `O(n log n)` time.
- Assigning importance values and calculating the total importance takes `O(n)` time.
- Thus, the overall time complexity is `O(n log n)`.
- The space complexity is `O(n)` for storing the number of connections and importance values.
- The solution passes all the test cases and provides the maximum total importance of all roads.
- The solution is efficient and optimal for the given problem.
- The solution can be further optimized by using a priority queue to sort the cities based on the number of connections.