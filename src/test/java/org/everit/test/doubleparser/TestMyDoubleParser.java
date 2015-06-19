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
        testCases.put("    123.456  asd".toCharArray(), Double.valueOf(123.456));
        testCases.put("   +123.456  asd".toCharArray(), Double.valueOf(123.456));
        testCases.put("   -123.456  asd".toCharArray(), Double.valueOf(-123.456));
        testCases.put("   ".toCharArray(), Double.valueOf(0));
        testCases.put("+".toCharArray(), Double.valueOf(0));
        testCases.put("-".toCharArray(), Double.valueOf(0));
        testCases.put("+-".toCharArray(), Double.valueOf(0));
        testCases.put("test".toCharArray(), Double.valueOf(0));
        //        testCases.put("2.7976931348623157e+308".toCharArray(), null);
        //        testCases.put("-2.7976931348623157e+308".toCharArray(), null);
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
