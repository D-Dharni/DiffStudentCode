/**
 * Plagiarism Checker
 * A tool for finding the longest shared substring between two documents.
 *
 * @author Zach Blick
 * @author Deven Dharni
 */
public class PlagiarismChecker {

    /**
     * This method finds the longest sequence of characters that appear in both texts in the same order,
     * although not necessarily contiguously.
     * @param doc1 the first document
     * @param doc2 the second
     * @return The length of the longest shared substring.
     */
    public static int longestSharedSubstring(String doc1, String doc2) {
        int[][] tabulation = new int[doc1.length() + 1][doc2.length() + 1];

        // Add the base cases
        for (int i = 0; i < doc1.length() + 1; i++) {
            tabulation[i][0] = 0;
        }

        for (int j = 0; j < doc2.length() + 1; j++) {
            tabulation[0][j] = 0;
        }

        // Loop through the table and start the tabulation iterative process
        for (int i = 1; i < doc1.length() + 1; i++) {
            for (int j = 1; j < doc2.length() + 1; j++) {
                // Because the code is shifted, the character has to be shifted too
                char doc1letter = doc1.charAt(i - 1);
                char doc2letter = doc2.charAt(j - 1);

                // Case 1 (they match): check top left
                if (doc1letter == doc2letter) {
                    tabulation[i][j] = 1 + tabulation[i-1][j-1];
                }

                // Case 2: take greater of up or left
                else {
                    tabulation[i][j] = Math.max(tabulation[i-1][j], tabulation[i][j-1]);
                }
            }
        }

        // Return final value
        return tabulation[doc1.length()][doc2.length()];
    }
}
