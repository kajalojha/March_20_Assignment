package March_20_Assignments;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class TrieNode {
    Map<Character, TrieNode> children;

    TrieNode() {
        children = new HashMap<>();
    }
}
public class Q4_Distinct_subString {
    static int distinctSubstrings(String S) {
        TrieNode root = new TrieNode();
        int count = 0;

        // Iterate through each suffix of the string
        for (int i = 0; i < S.length(); i++) {
            TrieNode current = root;
            for (int j = i; j < S.length(); j++) {
                char c = S.charAt(j);
                if (!current.children.containsKey(c)) {
                    current.children.put(c, new TrieNode());
                    count++; // Increment count for each new node added
                }
                current = current.children.get(c);
            }
        }

        // Adding 1 to count for the empty string
        return count + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            String S = scanner.next(); // Input string

            // Print the number of distinct substrings
            System.out.println(distinctSubstrings(S));
        }

        scanner.close();
    }
}
