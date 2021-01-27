package com.victormeng.leetcode.implement_trie_prefix_tree;

public class Trie {
    /**
     * Initialize your data structure here.
     */
    Node root;

    public Trie() {
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node tmp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (tmp.children[c - 'a'] == null) {
                tmp.children[c - 'a'] = new Node(c);
            }
            tmp = tmp.children[c - 'a'];
        }
        tmp.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node tmp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (tmp.children[c - 'a'] == null) {
                return false;
            }
            tmp = tmp.children[c - 'a'];
        }
        return tmp.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node tmp = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (tmp.children[c - 'a'] == null) {
                return false;
            }
            tmp = tmp.children[c - 'a'];
        }
        return true;
    }
}

class Node {
    boolean isEnd;
    Node[] children;
    char content;

    Node() {
        this.children = new Node[26];
    }

    Node(char content) {
        this.content = content;
        this.children = new Node[26];
    }
}
