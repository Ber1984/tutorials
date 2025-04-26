package com.erick.company.LeetCode.tree.redblack.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieImpl {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("can");
        trie.insert("cap");
        trie.insert("dog");
        trie.search("cat");
    }


}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
}

class Trie {
    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current = current.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        current.isEndOfWord = true;
    }

    //search a specific word specific
    public boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (!current.children.containsKey(ch)) return false;
            current = current.children.get(ch);
        }
        return current.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            if (!current.children.containsKey(ch)) return false;
            current = current.children.get(ch);
        }
        return true;
    }
}

