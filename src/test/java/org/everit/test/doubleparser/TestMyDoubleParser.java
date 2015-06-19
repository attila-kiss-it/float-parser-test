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
    // TODO create more test cases to test your implementation
    testCases.put("1".toCharArray(), Double.valueOf(1));
  }

  @Test
  public void testStrtod() {
    for (Entry<char[], Double> testCase : testCases.entrySet()) {
      char[] testInput = testCase.getKey();
      double expectedOutput = testCase.getValue();
      Assert.assertEquals(expectedOutput, doubleParser.strtod(testInput), DELTA);
    }
  }

  @Test
  public void myTest() {
    Assert.assertEquals(12.12, doubleParser.strtod(new char[] { '1', '2', '.', '1', '2' }), 0);
  }

}
