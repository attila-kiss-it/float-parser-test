package org.everit.test.doubleparser;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestMyDoubleParser {

  private static final double DELTA = 0.000000001;

  private final DoubleParser doubleParser = new MyDoubleParser();

  private final Map<char[], Double> testCases = new HashMap<char[], Double>();

  @Before
  public void before() {
    testCases.clear();
    testCases.put("1".toCharArray(), Double.valueOf(1));
    testCases.put("10".toCharArray(), Double.valueOf(10));
    testCases.put("11".toCharArray(), Double.valueOf(11));
    testCases.put("123".toCharArray(), Double.valueOf(123));
    testCases.put("-2".toCharArray(), Double.valueOf(-2));
    testCases.put("-122".toCharArray(), Double.valueOf(-122));
    testCases.put("0.1".toCharArray(), Double.valueOf(0.1));
    testCases.put("0.11".toCharArray(), Double.valueOf(.11));
    testCases.put("-12.17".toCharArray(), Double.valueOf(-12.17));
  }

  @Test
  public void testStrtod() {
    for (Entry<char[], Double> testCase : testCases.entrySet()) {
      char[] testInput = testCase.getKey();
      double expectedOutput = testCase.getValue();
      Assert.assertEquals(expectedOutput, doubleParser.strtod(testInput), DELTA);
    }
  }

}
