package com.pakio.loudsTrie;

import com.carrotsearch.sizeof.RamUsageEstimator;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import java.io.IOException;
import java.net.URL;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    Trie trie = new Trie();

    URL sourceFile = Resources.getResource("LICENSE.txt");
    String targetString = Resources.toString(sourceFile, Charsets.UTF_8);
    String delim = " \n\r\t,.;";
    StringTokenizer st = new StringTokenizer(targetString,delim);
    while (st.hasMoreTokens()) {
      trie.add(st.nextToken());
    }

    LOUDS louds = trie.convert();

    System.out.println("Trie size(byte) -> " + RamUsageEstimator.sizeOf(trie));
    System.out.println("LOUDS size(byte) -> " + RamUsageEstimator.sizeOf(louds));

    System.out.println("match \"one\" -> " + louds.match("one"));
    System.out.println("match \"onee\" -> " + louds.match("onee"));
  }
}
