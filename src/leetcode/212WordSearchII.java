package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : WordSearchII
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 212. Word Search II
 */
public class WordSearchII {
    /**
     * Given a 2D board and a list of words from the dictionary, find all words in the board.

     Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

     For example,
     Given words = ["oath","pea","eat","rain"] and board =

     [
     ['o','a','a','n'],
     ['e','t','a','e'],
     ['i','h','k','r'],
     ['i','f','l','v']
     ]
     Return ["eat","oath"].

     time : O(m * n * TrieNode)
     space : TrieNode

     * @param board
     * @param words
     * @return
     */

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {
            res.add(p.word);
            p.word = null;
        }
        board[i][j] = '#';
        dfs(board, i - 1, j, p, res);
        dfs(board, i + 1, j, p, res);
        dfs(board, i, j + 1, p, res);
        dfs(board, i, j - 1, p, res);
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) {
                    p.next[i] = new TrieNode();
                }
                p = p.next[i];
            }
            p.word = word;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}


*****************************


class Solution2 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode node, List<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        char c = board[i][j];
        //矩阵中没有||字典树中没有,那么结束dfs
        if (c == '#' || node.children[c - 'a'] == null) return;
        node = node.children[c - 'a'];//Tire树dfs向下延伸至其子节点
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';
        dfs(board, i - 1, j, node, res);
        dfs(board, i + 1, j, node, res);
        dfs(board, i, j + 1, node, res);
        dfs(board, i, j - 1, node, res);
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (node.children[i] == null) {
                    node.children[i] = new TrieNode();
                }
                node = node.children[i];
            }
            node.word = word;
        }
        return root;
    }

    class TrieNode{
        TrieNode children[] = new TrieNode[26];
        //boolean isEnd;
        String word;
    }
}




*****************************

class Solution3 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode node, List<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        char c = board[i][j];
        //矩阵中没有||字典树中没有,那么结束dfs
        if (c == '#' || node.children[c - 'a'] == null) return;
        node = node.children[c - 'a'];//Tire树dfs向下延伸至其子节点
        // if (node.word != null) {//是否是一个完整的单词
        //     res.add(node.word);
        //     node.word = null;//这里置null，是为了重复结果出现
        // }
        if(node.isEnd) {//是否是一个完整的单词,到了末尾了
            res.add(node.word);
            node.isEnd = false;//这里置false，也是为了避免重复结果出现,也就是说我这个单词已经在字典树里搜索过一次了，就不要再搜第2次了，例如:输入:
            //[["a","a"]]
            //["a"]
            //正确输出:["a"],如果不置false,则错误输出:["a"]
        }
        board[i][j] = '#';
        dfs(board, i - 1, j, node, res);
        dfs(board, i + 1, j, node, res);
        dfs(board, i, j + 1, node, res);
        dfs(board, i, j - 1, node, res);
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (node.children[i] == null) {
                    node.children[i] = new TrieNode();
                }
                node = node.children[i];
            }
            //node.word = word;
            node.isEnd=true;
        }
        return root;
    }

    class TrieNode{
        TrieNode children[] = new TrieNode[26];
        boolean isEnd=false;
        String word="";
    }
}


