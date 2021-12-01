package com.pakio.loudsTrie;

public class Main {
  public static void main(String[] args) {
    Trie trie = new Trie();

    trie.add("an");
    trie.add("i");
    trie.add("of");
    trie.add("one");
    trie.add("our");
    trie.add("out");

    LOUDS louds = trie.convert();

    System.out.println(louds.match("one"));
    System.out.println(louds.match("on"));
  }
}
