package com.pakio.loudsTrie;

import java.util.HashMap;
import java.util.Map;

public class Node {
  private final char key;
  private boolean isLeaf;
  private Map<Character, Node> childNodes;

  public Node(char k) {
    key = k;
    childNodes = new HashMap<>();
  }

  public char getKey() {
    return key;
  }

  public void setIsLeaf() {
    isLeaf = true;
  }

  public boolean isLeaf() {
    return isLeaf;
  }

  public void add(Node childNode) {
    childNodes.put(childNode.getKey(), childNode);
  }

  public boolean hasChild() {
    return !childNodes.isEmpty();
  }

  public boolean keyExists(char c) {
    return this.childNodes.containsKey(c);
  }

  public Map<Character, Node> getChildNodes() {
    return childNodes;
  }

  public Node getChildNode(char c) {
    return childNodes.get(c);
  }
}
