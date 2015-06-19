package org.everit.test.doubleparser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MyDoubleParser implements DoubleParser {

  private Map<Character, Integer> numberMap = new HashMap<>();

  public MyDoubleParser() {
    super();
    numberMap.put('0', 0);
    numberMap.put('1', 1);
    numberMap.put('2', 2);
    numberMap.put('3', 3);
    numberMap.put('4', 4);
    numberMap.put('5', 5);
    numberMap.put('6', 6);
    numberMap.put('7', 7);
    numberMap.put('8', 8);
    numberMap.put('9', 9);
  }

  private List<Integer> integerNumbers = new ArrayList<>();

  private boolean decimalPointFound = false;

  private List<Integer> floatingNumbers = new ArrayList<>();

  private boolean poitive = false;

  @Override
  public double strtod(final char[] str) {
    Objects.requireNonNull(str, "str cannot be null");

    for (int i = 0; i < str.length; i++) {
      if (Character.isWhitespace(str[i])) {
        // skip
      } else if ('.' == str[i]) {
        decimalPointFound = true;
      } else if ('+' == str[i]) {
        poitive = true;
      } else if (numberMap.containsKey(str[i])) {
        if (decimalPointFound) {
          floatingNumbers.add(numberMap.get(str[i]));
        } else {
          integerNumbers.add(numberMap.get(str[i]));
        }
      }
    }

    return createDouble(integerNumbers, floatingNumbers, poitive);

  }

  private Double createDouble(List<Integer> intNumbers, List<Integer> floatNumbers,
      boolean positive) {
    Double result = 0.0;
    int size = intNumbers.size();
    for (int i = intNumbers.size() - 1; i >= 0; i--) {
      if (i == size - 1) {
        result += intNumbers.get(i);
      } else {
        result += intNumbers.get(i) * ((size - i - 1) * 10); // not dinamic yet
      }
    }
    size = floatNumbers.size();
    for (int i = 0; i < size; i++) {
      if (i == 0) {
        result += floatNumbers.get(i) * 0.1;
      } else {
        result += floatNumbers.get(i) * 0.01; // not dinamic yet
      }
    }
    return result;
  }

}
