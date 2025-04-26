A Trie (also called a Prefix Tree) is a specialized tree used to store associative data structures where the keys are usually strings — especially useful when all keys share common prefixes.

Key Concepts of a Trie:
Each node represents a character.

The path from root to a node forms a prefix of some word.

Each node has a map of child nodes, typically from char to TrieNode.

End of word is marked with a flag (isEndOfWord = true).

Let’s insert the words ["cat", "cap", "can"] into a Trie:


         (root)
          /  
         c
        /
       a
     / | \
    t  p  n

All three words share the prefix "ca" so they branch from the same root path.

Common Use Cases:
🔍 Autocomplete

✅ Spell checking

🔄 Prefix-based searching

🔐 IP routing (prefix matching)

📱 Contact search by name

Great question! Yes, even a single character like "c" is a valid prefix — and with just that, you can already suggest all words in the trie that start with "c" like "cat", "cap", and "can".

In Tries:
Prefix "c" → matches all words that begin with "c".

Prefix "ca" → narrows it further.

Prefix "cat" → matches exactly "cat".

So if a user types:

"c" → show: ["cat", "cap", "can"]

"ca" → still: ["cat", "cap", "can"]

"cap" → only: ["cap"]
