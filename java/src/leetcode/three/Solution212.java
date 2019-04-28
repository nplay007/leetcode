package JavaAnswer.three;

import java.util.ArrayList;
import java.util.List;

public class Solution212 {
    class TrieNode {
        TrieNode[] children;
        String word;

        TrieNode() {
            children = new TrieNode[256];
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, root, result, board);
            }
        }
        return result;
    }

    public void dfs(int i, int j, TrieNode ptr, List<String> result, char[][] board) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        char ch = board[i][j];
        if (ch == '#' || ptr.children[ch] == null) {
            return;
        }
        ptr = ptr.children[ch];
        if (ptr.word != null) {
            result.add(ptr.word);
            ptr.word = null;
        }

        board[i][j] = '#';
        dfs(i - 1, j, ptr, result, board);
        dfs(i, j - 1, ptr, result, board);
        dfs(i + 1, j, ptr, result, board);
        dfs(i, j + 1, ptr, result, board);
        board[i][j] = ch;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode ptr = root;
            for (char ch : word.toCharArray()) {
                if (ptr.children[ch] == null) {
                    ptr.children[ch] = new TrieNode();
                }
                ptr = ptr.children[ch];
            }
            ptr.word = word;
        }
        return root;
    }
}