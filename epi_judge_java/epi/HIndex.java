package epi;

import java.util.Comparator;
import java.util.List;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class HIndex {
  @EpiTest(testDataFile = "h_index.tsv")
  public static int hIndex(List<Integer> citations) {
    citations.sort(Comparator.naturalOrder());

    int hValue = 0;

    for (int i = 0; i < citations.size(); i++) {
      int count = citations.size() - i;

      int h = Integer.min(count, citations.get(i));

      hValue = Integer.max(hValue, h);
    }

    return hValue;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "HIndex.java",
                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
