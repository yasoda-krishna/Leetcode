/**
 * Name : Yasoda Krishna Reddy Annapureddy
 * Date : 06/27/2023
 * Time : 11:30 PM
 */

import java.util.Arrays;

class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] occur = new int[n];
        for (int[] r : roads) {
            occur[r[0]]++;
            occur[r[1]]++;
        }

        Integer[] val = new Integer[n];
        for (int i = 0; i < n; i++) {
            val[i] = i;
        }

        Arrays.sort(val, (a, b) -> Integer.compare(occur[b], occur[a]));

        int[] out = new int[n];
        for (int i = 0; i < n; i++) {
            out[val[i]] = n - i;
        }

        long total = 0;
        for (int[] r : roads) {
            total += out[r[0]] + out[r[1]];
        }

        return total;
    }
}