
class TrieNode {
    TrieNode[] child = new TrieNode[26];
    List<String> suggestions = new ArrayList<>();
}

class Solution {

    public List<List<String>> suggestedProducts(
        String[] products, String searchWord) {

        Arrays.sort(products);

        TrieNode root = new TrieNode();

        // Insert all products
        for (String word : products) {
            TrieNode curr = root;

            for (char c : word.toCharArray()) {
                int idx = c - 'a';

                if (curr.child[idx] == null) {
                    curr.child[idx] = new TrieNode();
                }

                curr = curr.child[idx];

                // Store only first 3 products
                if (curr.suggestions.size() < 3) {
                    curr.suggestions.add(word);
                }
            }
        }

        // Search suggestions
        List<List<String>> ans = new ArrayList<>();
        TrieNode curr = root;

        for (char c : searchWord.toCharArray()) {

            int idx = c - 'a';

            if (curr != null) {
                curr = curr.child[idx];
            }

            if (curr == null) {
                ans.add(new ArrayList<>());
            } else {
                ans.add(curr.suggestions);
            }
        }

        return ans;
    }
}
