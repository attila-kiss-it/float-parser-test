package org.everit.test.doubleparser;

import java.util.ArrayList;

public class MyDoubleParser implements DoubleParser {

  @Override
  public double strtod(final char[] str) {

    // TODO Implement me in 40 minutes!
    int i = 0;
    
    boolean isPositive = true;
    boolean hasFraction = false;
    
    while(Character.isWhitespace(str[i])) {
    	i++;
    }
    
    if(str[i] == '+') {
    	i++;
    } else if(str[i] == '-') {
    	isPositive = false;
    	i++;
    }
    
    int startPoz = i;
    
    int j = 0;
    
    while(isNumber(str[i])) {
    	j++;
    	i++;
    }
    
    if(j==0) {
    	return 0;
    }
    
    if(str[i] == '.') {
    	i++;
    	hasFraction = true;
    }
    
    int k = 0;
    
    while(isNumber(str[i])) {
    	k++;
    	i++;
    }
    
    return 1;

  }
  
  boolean isNumber(char chr) {
	  if(chr == '0' || chr == '1' || chr == '2' || chr == '3' || chr == '4' || chr == '5' || chr == '6' || chr == '7' || chr == '8' || chr == '9') {
		  return true;
	  }
	  return false;
  }
  
  double calculate(char[] str, int startPoz, int whole, int fraction, boolean isPositive) {
	  double result = 0;
	  
	  int i = startPoz;
	  
	  while(isNumber(str[i])) {
		  switch (str[i]) {
		  case '1' : break;
		  case '2' : break;
		  case '3' : break;
		  case '4' : break;
		  case '5' : break;
		  case '6' : break;
		  case '7' : break;
		  case '8' : break;
		  case '9' : break;
		  }
	  }
  }
  
}
