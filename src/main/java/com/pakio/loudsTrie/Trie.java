package com.pakio.loudsTrie;

public class Trie {
  private Node rootNode;

  public Trie() {
    rootNode = new Node('-');
  }

  public void add(String s) {
    add(s.toCharArray(), 0, rootNode);
  }

  private static void add(char[] chars, int offset, Node node) {
    char key = chars[offset];

    Node childNode;
    if (node.keyExists(key)) {
      childNode = node.getChildNode(key);
    } else {
      childNode = new Node(key);
      node.add(childNode);
    }

    if (chars.length == offset + 1) {
      childNode.setIsLeaf();
      return;
    }

    add(chars, ++offset, childNode);
  }

  /**
   * convert tree to LOUDS
   */
  public LOUDS convert() {
    return Converter.convert(rootNode);
  }
}
