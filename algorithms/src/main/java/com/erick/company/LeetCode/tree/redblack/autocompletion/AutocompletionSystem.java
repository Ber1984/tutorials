package com.erick.company.LeetCode.tree.redblack.autocompletion;

/*
Do we need to pre-save words in the tree for autocomplete?
Yes, absolutely!
Autocomplete systems rely on having a predefined dictionary or corpus of words stored in a data structure like a Trie or Balanced Tree.
This is how it works:

Preprocessing phase: Load all known words (e.g., from a product catalog, search history, dictionary).

Insert into a Trie or Balanced BST.

As the user types, match the prefix and return suggestions in real-time.

If you're doing this on-the-fly without pre-inserting, autocomplete can't work efficiently or might not work at all.
 */
public class AutocompletionSystem {
}
