package com.pakio.loudsTrie;

import java.util.ArrayDeque;
import java.util.Map.Entry;
import java.util.Queue;

public class Converter {
  /**
   * convert tree to LOUDS
   */
  public static LOUDS convert(Node rootNode) {
    LOUDS louds = new LOUDS();
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(rootNode);

    while(!queue.isEmpty()) {
      processQueue(queue, louds);
    }

    return louds;
  }

  public static void processQueue(Queue<Node> queue, LOUDS louds) {
    Node node = queue.poll();

    if (node.hasChild()) {
      for(Entry<Character, Node> characterNodeMap : node.getChildNodes().entrySet()) {
        queue.add(characterNodeMap.getValue());
        louds.LBS.add(true);
        louds.labels.add(characterNodeMap.getKey());
        louds.isLeaf.add(characterNodeMap.getValue().isLeaf());
      }
    }

    // end of node
    louds.LBS.add(false);
    louds.isLeaf.add(false);
  }
}
