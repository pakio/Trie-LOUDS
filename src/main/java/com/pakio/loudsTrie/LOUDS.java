package com.pakio.loudsTrie;

import java.util.ArrayList;
import java.util.List;

public class LOUDS {
  List<Boolean> LBS;
  List<Character> labels;
  List<Boolean> isLeaf;

  public LOUDS () {
    LBS = new ArrayList<>();
    LBS.add(true);
    LBS.add(false);

    labels = new ArrayList<>();
    labels.add(null);
    labels.add(null);

    isLeaf = new ArrayList<>();
    isLeaf.add(false);
    isLeaf.add(false);
  }

  public boolean match(String s) {
    return search(2, s.toCharArray(), 0) == SearchStatus.LEAF_FOUND;
  }

  private SearchStatus search(int index, char[] chars, int wordOffset) {
    int charIndex = countTrue(index);
    while(LBS.get(index)) {
      if (chars[wordOffset] == labels.get(charIndex)) {
        if (isLeaf.get(index)) return SearchStatus.LEAF_FOUND;
        else if (wordOffset + 1 == chars.length) return SearchStatus.PART_CONTAINS;
        return search(indexOfLabel(charIndex), chars, ++wordOffset);
      } else {
        index ++;
      }
      charIndex ++;
    }
    return SearchStatus.NOT_FOUND;
  }

  private int countTrue(int to) {
    return (int)LBS.subList(0, to + 1).stream().filter(elm -> elm).count();
  }

  private int indexOfLabel(int label) {
    int count = 0, i = 0;
    for(; i < LBS.size(); i ++) {
      if (!LBS.get(i)) {
        if (++count == label) {
          break;
        }
      }
    }

    return i + 1;
  }

  enum SearchStatus {
    LEAF_FOUND,
    PART_CONTAINS,
    NOT_FOUND;
  }
}
