class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] lastPos = new int[m + 1];
        lastPos[m] = n; 
        int ptr = n - 1;
        for (int j = m - 1; j >= 0; j--) {
            while (ptr >= 0 && word1.charAt(ptr) != word2.charAt(j)) {
                ptr--;
            }
            lastPos[j] = ptr;
            if (ptr >= 0) {
                ptr--;
            }
        }
        int[] result = new int[m];
        boolean usedMismatch = false;
        int j = 0;
        for (int i = 0; i < n && j < m; i++) {
            boolean isMatch = (word1.charAt(i) == word2.charAt(j));
            if (isMatch) {
                result[j] = i;
                j++;
            } else if (!usedMismatch && i + 1 <= lastPos[j + 1]) {
                result[j] = i;
                usedMismatch = true;
                j++;
            }
        }
        if (j < m) {
            return new int[0];
        }
        return result;
    }
}